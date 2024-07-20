package com.example.web;
/**
 * Class name: ClientBookServlet
 * Package name: com.example.web
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: 客户首页Servlet
 * @Create_time: 2024/7/13-11:39
 */


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

@WebServlet(name = "ClientBookServlet", value = "/client/ClientBookServlet")
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 分页功能实现
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        int pageNo = Webutils.parseInt(request.getParameter("pageNo"), 1);

        int pageSize = Webutils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        Page<Book> page = bookService.page(pageNo, pageSize);


        page.setUrl("client/ClientBookServlet?action=page");

        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);

    }


    /**
     * 根据最大最小价格的分页实现
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        int pageNo = Webutils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = Webutils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = Webutils.parseInt(request.getParameter("min"), 0);
        int max = Webutils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/ClientBookServlet?action=pageByPrice");
        if(request.getParameter("min") != null){
            sb.append("&min=").append(request.getParameter("min"));

        }
        if(request.getParameter("max") != null){
            sb.append("&max=").append(request.getParameter("max"));

        }

        page.setUrl(sb.toString());

        request.setAttribute("page", page);

        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);

    }
}
