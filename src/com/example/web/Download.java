package com.example.web;

/**
 * Class name: ${NAME}
 * Package: ${PACKAGE_NAME}
 * Description:
 *
 * @Author: twl
 * @Create-time: 2024/5/30 - 19:21
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet(name = "Download", value = "/Download")
public class Download extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String downloadname = "a.png";
		ServletContext servletContext = getServletContext();
		String mimeType = servletContext.getMimeType("/file/" + downloadname);
		System.out.println("mimeType = " + mimeType);
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("中国.jpg", "utf-8"));

		InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadname);
		OutputStream outputStream = response.getOutputStream();
		IOUtils.copy(resourceAsStream, outputStream);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
