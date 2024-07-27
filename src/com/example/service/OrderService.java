package com.example.service;

import com.example.pojo.Cart;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;

import java.util.List;

/**
 * Class name: OrderService
 * Package name: com.example.service
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: OrderService
 * @Create_time: 2024/7/24-17:41
 */

public interface OrderService {


    String createOrder(Cart cart, Integer userId);

    List<Order> showAllOrders();

    int sendOrder(String orderId);

    List<OrderItem> showOrderDetail(String orderId);

    List<OrderItem> showMyOrders(Integer userId);

    void receiveOrder(String orderId);
}
