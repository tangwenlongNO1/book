package com.example.dao.impl;

import com.example.dao.OrderItemDao;
import com.example.pojo.OrderItem;

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
    public void queryOrderItemsByOrderId(Integer orderId) {

    }
}
