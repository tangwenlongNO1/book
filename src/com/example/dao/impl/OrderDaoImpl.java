package com.example.dao.impl;

import com.example.dao.OrderDao;
import com.example.pojo.Order;

/**
 * Class name: OrderDaoImpl
 * Package name: com.example.dao.impl
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/24-18:12
 */

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`, `create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public void queryOrders() {

    }

    @Override
    public void changeOrderStatus(Integer orderId, Integer status) {

    }

    @Override
    public void queryOrdersByUserId(Integer userId) {

    }
}
