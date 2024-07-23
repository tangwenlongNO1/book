package com.example.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class name: Order
 * Package name: com.example.pojo
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: 订单
 * @Create_time: 2024/7/22-19:05
 */

public class Order {

    private Integer id;
    private Map<Integer, OrderItem> items = new LinkedHashMap<Integer, OrderItem>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, OrderItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
