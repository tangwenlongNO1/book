package com.example.service;

import com.example.pojo.Cart;

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

    void showAllOrders();

    void sendOrder(Integer orderId);

    void showOrderDetail(Integer orderId);

    void showMyOrders(Integer userId);

    void receiveOrder(Integer orderId);
}
