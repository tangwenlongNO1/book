package com.example.dao;

import com.example.pojo.OrderItem;

/**
 * Class name: OrderItemDao
 * Package name: com.example.dao
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/24-17:48
 */

public interface OrderItemDao {

    /**
     * 保存订单项
     * @param orderItem 订单项
     * @return 数据库改变的行数
     */
    int saveOrderItem(OrderItem orderItem);

    void queryOrderItemsByOrderId(Integer orderId);

}
