package com.example.web;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/manager/BookServlet")
public class BookServlet extends BaseServlet {
	// private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageNo = Webutils.parseInt(request.getParameter("pageNo"), 0);
		pageNo+=1;
		Book book = Webutils.copyparamtobean(request.getParameterMap(), new Book());
		bookService.addBook(book);
		response.sendRedirect(request.getContextPath() + "/manager/BookServlet?action=page&pageNo=" + pageNo);

	}
	
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		int pageNo = Webutils.parseInt(request.getParameter("pageNo"), 1);

		int pageSize = Webutils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

		Page<Book> page = bookService.page(pageNo, pageSize);

		page.setUrl("manager/BookServlet?action=page");

		request.setAttribute("page", page);

		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i = Webutils.parseInt(request.getParameter("id"), 0);
		bookService.deleteBookById(i);
		response.sendRedirect(request.getContextPath() + "/manager/BookServlet?action=page&pageNo=" + request.getParameter("pageNo"));

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Book book = Webutils.copyparamtobean(request.getParameterMap(), new Book());

		bookService.updateBook(book);

		response.sendRedirect(request.getContextPath() + "/manager/BookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
	}

	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Webutils.parseInt(request.getParameter("id"), 0);
		Book book = bookService.queryBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}

	protected void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Book> books = bookService.queryBooks();
		request.setAttribute("books", books);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

	}

}
