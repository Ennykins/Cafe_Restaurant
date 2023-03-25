package com.example.cafe94.entities;


import com.example.cafe94.enums.OrderType;
import com.example.cafe94.utils.IdGenerator;

import java.time.LocalDate;


public class Booking {

    private int id = 0;
    private int tableId = 0;
    private LocalDate date = LocalDate.now();
    private String time = "";
    private int customerId = 0;
    private int orderDefaultDuration = 1;
    private boolean approved = false;


    public Booking() {

        id = IdGenerator.generateBookingId();
    }


    public boolean isOrderValid(){
        return true;//LocalDateTime.now().compareTo(date);
    }
    public void extendOrder(int orderDefaultDuration){
        this.orderDefaultDuration = orderDefaultDuration;

    }    public void cancelOrder(){


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
