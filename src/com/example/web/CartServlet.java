package com.example.web;
/**
 * Class name: ${NAME}
 * Package name: ${PACKAGE_NAME}
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/20-17:34
 */


import com.example.pojo.Book;
import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import com.example.utils.Webutils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();
    /**
     * 添加购物车
     * @param request 请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Webutils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);

        response.sendRedirect(request.getHeader("Referer"));
    }


}
