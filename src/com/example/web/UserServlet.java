package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.Webutils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.userLogin(new User(null, username, password, null));
        if (user == null) {

            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }

    }

    protected void loginout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        // 反射机制
        User user = Webutils.copyparamtobean(request.getParameterMap(), new User());

        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {

                request.setAttribute("msg", "用户名已存在！！");
                request.setAttribute("username", username);
                request.setAttribute("mail", email);
                System.out.println("用户名" + username + "已存在！");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                userService.registUser(new User(null, username, password, email));
                request.getSession().setAttribute("user", new User(null, username, password, email));
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {

            request.setAttribute("msg", "验证码错误！！");
            request.setAttribute("username", username);
            request.setAttribute("mail", email);

            System.out.println("验证码" + code + "错误！");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

        }

    }

    protected void ajaxExistUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");

        boolean b = userService.existUsername(username);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("existUsername", b);

        Gson gson = new Gson();
        String s = gson.toJson(resultMap);

        response.getWriter().write(s);

    }
}
