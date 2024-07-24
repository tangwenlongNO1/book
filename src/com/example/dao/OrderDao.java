package com.example.dao;

import com.example.pojo.Order;

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

    void queryOrders();

    void changeOrderStatus(Integer orderId, Integer status);

    void queryOrdersByUserId(Integer userId);


}
