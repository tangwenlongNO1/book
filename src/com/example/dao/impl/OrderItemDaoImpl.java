package com.example.dao.impl;

import com.example.dao.OrderItemDao;
import com.example.pojo.OrderItem;

import java.util.List;

/**
 * Class name: OrderItemDaoImpl
 * Package name: com.example.dao.impl
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: OrderItemDaoItem
 * @Create_time: 2024/7/24-18:13
 */

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {

        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";

        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {

        String sql = "select `id`,`name`,`price`,`total_price` totalPrice,`order_id` orderId from t_order_item where `order_id`=?";

        return queryForList(OrderItem.class, sql, orderId);

    }

    @Override
    public List<OrderItem> queryOrderItemsByUserId(Integer userId) {

        String sql = "select `id`,`name`,`price`,`total_price` totalPrice,`order_id` orderId from t_order_item where `order_id`in (select `order_id` from t_order where `user_id`=? )";
        return queryForList(OrderItem.class, sql, userId);
    }
}
