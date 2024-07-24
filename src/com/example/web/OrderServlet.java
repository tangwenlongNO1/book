package com.example.web;
/**
 * Class name: ${NAME}
 * Package name: ${PACKAGE_NAME}
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: OrderServlet
 * @Create_time: 2024/7/24-17:26
 */


import com.example.pojo.Cart;
import com.example.pojo.User;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BaseServlet {

    /**
     * 创建订单
     * @param request 请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException IO异常
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = user.getId();

        OrderService orderService = new OrderServiceImpl();

        String orderId = orderService.createOrder(cart, userId);

        request.getSession().setAttribute("orderId", orderId);

        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");

    }

    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
