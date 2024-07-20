package com.example.web;

/**
 * Class name: ${NAME}
 * Package: ${PACKAGE_NAME}
 * Description:
 *
 * @Author: twl
 * @Create-time: 2024/4/20 - 14:44
 */

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet", value = "/RegistServlet")
public class RegistServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");

		if ("abcde".equalsIgnoreCase(code)) {
			if (userService.existUsername(username)) {

				request.setAttribute("msg", "用户名已存在！！");
				request.setAttribute("username", username);
				request.setAttribute("mail", email);
				System.out.println("用户名" + username + "已存在!");
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			} else {
				userService.registUser(new User(null, username, password, email));
				request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
			}
		} else {

			request.setAttribute("msg", "验证码错误！！");
			request.setAttribute("username", username);
			request.setAttribute("mail", email);

			System.out.println("验证码" + code + "错误!");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

		}
	}
}
