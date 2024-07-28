package com.example.test;

import com.example.dao.OrderDao;
import com.example.dao.impl.OrderDaoImpl;
import com.example.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Class name: OrderDaoTest
 * Package name: com.example.test
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/24-18:22
 */

public class OrderDaoTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234567789", new Date(), new BigDecimal(3636), 0, 1));
    }

    @Test
    public void queryOrders() {

        OrderDao orderDao = new OrderDaoImpl();

        List<Order> orders = orderDao.queryOrders();

        orders.forEach(System.out::println);
    }

    @Test
    public void changeOrderStatus() {

        OrderDao orderDao = new OrderDaoImpl();

        orderDao.changeOrderStatus("17218180982681", 1);
    }

    @Test
    public void queryOrdersByUserId() {

        OrderDao orderDao = new OrderDaoImpl();

        List<Order> orders = orderDao.queryOrdersByUserId(5);

        orders.forEach(System.out::println);
    }


}