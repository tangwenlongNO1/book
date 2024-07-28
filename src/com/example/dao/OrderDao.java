package com.example.dao;

import com.example.pojo.Order;

import java.util.List;

/**
 * Class name: OrderDao
 * Package name: com.example.dao
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/24-17:48
 */

public interface OrderDao {

    /**
     * 保存订单
     * @param order 订单
     * @return 数据库改变行数
     */
    int saveOrder(Order order);

    /**
     * 查询所有订单
     * @return List<Order> 订单
     */
    List<Order> queryOrders();

    /**
     * 改变订单状态
     * @param orderId 订单Id
     * @param status 状态
     * @return 数据库改变行数
     */
    int changeOrderStatus(String orderId, Integer status);

    /**
     * 通过userId查询订单
     * @param userId 用户Id
     * @return 订单
     */
    List<Order> queryOrdersByUserId(Integer userId);


}
