package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.OrderDao;
import com.example.dao.OrderItemDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.dao.impl.OrderDaoImpl;
import com.example.dao.impl.OrderItemDaoImpl;
import com.example.pojo.*;
import com.example.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Class name: OrderServiceImpl
 * Package name: com.example.service.impl
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: OrderServiceImpl
 * @Create_time: 2024/7/24-17:43
 */

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();


    /**
     * 创建订单
     * @param cart 购物车
     * @param userId 用户ID
     * @return orderId 订单ID
     */
    @Override
    public String createOrder(Cart cart, Integer userId) {

        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem cartItem = entry.getValue();

            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);

            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setSales(book.getStock() - cartItem.getCount());

            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {



        return orderDao.queryOrders();
    }

    @Override
    public int sendOrder(String orderId) {

        return orderDao.changeOrderStatus(orderId, 1);

    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {

        return orderItemDao.queryOrderItemsByOrderId(orderId);

    }

    @Override
    public List<OrderItem> showMyOrders(Integer userId) {

//        String orderId;
//
//        return orderItemDao.queryOrderItemsByOrderId(orderId);
        return null;


    }

    @Override
    public void receiveOrder(String orderId) {

    }
}
