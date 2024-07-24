package com.example.test;

import com.example.dao.OrderItemDao;
import com.example.dao.impl.OrderItemDaoImpl;
import com.example.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Class name: OrderItemDaoTest
 * Package name: com.example.test
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/24-18:29
 */

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {

        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null, "我的饭圈", 1, new BigDecimal(100), new BigDecimal(100), "1234567789"));
        orderItemDao.saveOrderItem(new OrderItem(null, "java从入门到放弃", 1, new BigDecimal(100), new BigDecimal(100), "1234567789"));
        orderItemDao.saveOrderItem(new OrderItem(null, "我的乒乓", 12, new BigDecimal(100), new BigDecimal(1200), "1234567789"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
    }
}