package com.example.cafe94.entities;


import com.example.cafe94.enums.OrderType;
import com.example.cafe94.utils.IdGenerator;

import java.time.LocalDateTime;

public class Order {

    private int id = 0;
    private String menu = "";
    private int customerId = 0;
    private OrderType type;
    private String address = "";
    private boolean fulfilled = false;
    private LocalDateTime date = LocalDateTime.now();
    public Order() {

        id = IdGenerator.generateOrderId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        this.fulfilled = fulfilled;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
