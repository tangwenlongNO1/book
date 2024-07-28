package com.example.test;

import com.example.pojo.Cart;
import com.example.pojo.CartItem;
import com.example.pojo.Order;
import com.example.pojo.OrderItem;
import com.example.service.OrderService;
import com.example.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

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

    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "c++", 1, new BigDecimal(100), new BigDecimal(100)));


        System.out.println("订单号是：" + orderService.createOrder(cart, 1));
    }

    @Test
    public void showAllOrders() {

        OrderService orderService = new OrderServiceImpl();

        List<Order> orders = orderService.showAllOrders();

        orders.forEach(System.out::println);
    }

    @Test
    public void sendOrder() {


        orderService.sendOrder("17218180982681");

    }

    @Test
    public void showOrderDetail() {

        List<OrderItem> orderItems = orderService.showOrderDetail("17218189043571");

        orderItems.forEach(System.out::println);
    }

    @Test
    public void showMyOrders() {

        List<Order> orders = orderService.showMyOrders(1);

        orders.forEach(System.out::println);
    }

    @Test
    public void receiveOrder() {

        orderService.receiveOrder("17218189819941");
    }
}