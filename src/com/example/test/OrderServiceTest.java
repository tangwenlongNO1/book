package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Class name: OrderServiceTest
 * Package name: com.example.test
 * Project name: book
 *
 * @Author: Jason Tom
 * Description:
 * @Create_time: 2024/7/24-18:44
 */

public class OrderServiceTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "c++", 1, new BigDecimal(100), new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }

    @Test
    public void showAllOrders() {
    }

    @Test
    public void sendOrder() {
    }

    @Test
    public void showOrderDetail() {
    }

    @Test
    public void showMyOrders() {
    }

    @Test
    public void receiveOrder() {
    }
}