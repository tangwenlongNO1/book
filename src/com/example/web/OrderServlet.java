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
import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.pojo.User;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BaseServlet {

    /**
     * 创建订单
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = user.getId();

        OrderService orderService = new OrderServiceImpl();

        String orderId = orderService.createOrder(cart, userId);

        // 使用session
        request.getSession().setAttribute("orderId", orderId);
        // 重定向到结算页面
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");

    }

    /**
     * 展示所有订单
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderService orderService = new OrderServiceImpl();

        List<Order> orders = orderService.showAllOrders();

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);


    }

    /**
     * 发货
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("orderId");

        OrderService orderService = new OrderServiceImpl();

        orderService.sendOrder(orderId);

        request.getRequestDispatcher("/OrderServlet?action=showAllOrders").forward(request, response);
        // response.sendRedirect(request.getContextPath() + "/pages/manager/order_manager.jsp");


    }

    /**
     * 展示订单细节
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderService orderService = new OrderServiceImpl();

        String orderId = request.getParameter("orderId");

        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);

        request.setAttribute("orderItems", orderItems);

        request.getRequestDispatcher("/pages/order/orderdetail.jsp").forward(request, response);

    }

    /**
     * 展示我的订单
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrderService orderService = new OrderServiceImpl();

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = user.getId();

        List<Order> orders = orderService.showMyOrders(userId);

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);

    }

    /**
     * 收货
     *
     * @param request  请求
     * @param response 响应
     * @throws ServletException servlet异常
     * @throws IOException      IO异常
     */
    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("orderId");

        OrderService orderService = new OrderServiceImpl();

        orderService.receiveOrder(orderId);

        request.getRequestDispatcher("/OrderServlet?action=showMyOrders").forward(request, response);

    }

}
