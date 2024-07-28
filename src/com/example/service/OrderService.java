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


    /**
     * 生成订单
     * @param cart 购物车
     * @param userId 用户Id
     * @return orderId
     */
    String createOrder(Cart cart, Integer userId);

    /**
     * 展示所有订单
     * @return 订单
     */
    List<Order> showAllOrders();

    /**
     * 发货
     * @param orderId 订单Id
     * @return 数据库改变行数
     */
    int sendOrder(String orderId);

    /**
     * 展示订单详情
     * @param orderId 订单Id
     * @return 订单item
     */
    List<OrderItem> showOrderDetail(String orderId);

    /**
     * 我的订单
     * @param userId 用户Id
     * @return 订单
     */
    List<Order> showMyOrders(Integer userId);

    /**
     * 收货
     * @param orderId 订单Id
     * @return 数据库改变行数
     */
    int receiveOrder(String orderId);
}
