package com.example.service;

import com.example.pojo.Cart;
import com.example.pojo.Order;

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

    void showOrderDetail(String orderId);

    void showMyOrders(Integer userId);

    void receiveOrder(String orderId);
}
