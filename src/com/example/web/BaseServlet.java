package com.example.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/BaseServlet")
public abstract class BaseServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");

		try {
			Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class,
					HttpServletResponse.class);
			// System.out.println(method);

			method.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
