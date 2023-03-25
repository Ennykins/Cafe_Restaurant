package com.example.cafe94.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    List<Table> tables;
    private  Map<String, Staff> staffDB = new LinkedHashMap<>();
    private  Map<String, Customer> customerDB = new LinkedHashMap<>();
    private  Map<Integer, String> customerIdToUsernameDB = new LinkedHashMap<>();

    private  Map<Integer, Booking> bookingDB = new LinkedHashMap<>();
    private  Map<Integer, Order> orderDB = new LinkedHashMap<>();
    private  Map<Integer, Menu> menuDB = new LinkedHashMap<>();
    private  Map<Integer, Table> tableDB = new LinkedHashMap<>();

    public Restaurant() {
        tables = new ArrayList<>();
        tables.add(new Table(2));
        tables.add(new Table(2));
        tables.add(new Table(2));
        tables.add(new Table(2));

        tables.add(new Table(4));
        tables.add(new Table(4));
        tables.add(new Table(4));
        tables.add(new Table(4));

        tables.add(new Table(8));
        tables.add(new Table(8));
        tables.add(new Table(10));

        tables.forEach(t -> tableDB.put(t.getId(), t));

    }

    public int getTotalSeatCapacity() {
return tables.stream().mapToInt(Table::getTotalCapacity).sum();
    }

    public int getCurrentSeatCapacity() {
return tables.stream().mapToInt(Table::getCurrentCapacity).sum();
    }






   public Map<String, Customer> getCustomerDB(){
       return customerDB;
   }
   public Map<String, Staff> getStaffDB(){
        return staffDB;
    }


   public Map<Integer, Booking> getBookingDB(){
       return bookingDB;
   }

   public Map<Integer, Menu> getMenuDB(){
       return menuDB;
   }
   public Map<Integer, Order> getOrderDB(){
       return orderDB;
   }
   public Map<Integer, Table> getTableDB(){
       return tableDB;
   }
   public Map<Integer, String> getCustomerIdToUsernameDB(){
       return customerIdToUsernameDB;
   }


}
