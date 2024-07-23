package com.example.pojo;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Class name: OrderItem
 * Package name: com.example.pojo
 * Project name: book
 *
 * @Author: Jason Tom
 * Description: 订单Item
 * @Create_time: 2024/7/22-19:07
 */

public class OrderItem {

    private Integer id;
    private Date date;
    private BigDecimal price;
    private String status;

    public OrderItem() {
    }

    public OrderItem(Integer id, Date date, BigDecimal price, String status) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", date=" + date +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
