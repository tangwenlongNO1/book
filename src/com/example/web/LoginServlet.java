package com.example.web;

/**
 * Class name: ${NAME}
 * Package: ${PACKAGE_NAME}
 * Description:
 *
 * @Author: twl
 * @Create-time: 2024/4/22 - 13:07
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

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.userLogin(new User(null, username, password, null));
		if (user == null) {

			request.setAttribute("msg", "用户名或密码错误！");
			request.setAttribute("username", username);
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
		}
	}
}
