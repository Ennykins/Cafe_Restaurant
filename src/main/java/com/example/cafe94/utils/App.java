package com.example.cafe94.utils;



import com.example.cafe94.entities.*;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class App {
private static Restaurant restaurant = new Restaurant();
    private  static Customer loggedInCustomer;
    private  static Staff loggedInStaff;
    private static Stack<SceneNode> sceneHistory= new Stack<>();

    public static Customer getLoggedInCustomer(){
        return loggedInCustomer;
    }

    public  static Customer loginCustomer(String email, String password) throws Exception {

        if(!restaurant.getCustomerDB().containsKey(email)) throw new Exception("User not found");
        Customer customer = restaurant.getCustomerDB().get(email);
        if(!customer.getPassword().equals(password)) throw new Exception("User not found");
        loggedInCustomer = customer;
        return customer;
    }

    public  static Customer registerCustomer(Customer customer) throws Exception {

        if(restaurant.getCustomerDB().containsKey(customer.getEmail())) throw new Exception("Email already exists");

        restaurant.getCustomerDB().put(customer.getEmail(), customer);
        restaurant.getCustomerIdToUsernameDB().put(customer.getId(), customer.getEmail());
        return customer;
    }

    public  static List<Booking> getBookingList() {
        try{
            return restaurant.getBookingDB().values().stream().filter((b) -> b.getCustomerId() == loggedInCustomer.getId()).collect(Collectors.toList());

        }catch(Exception e){
            return new ArrayList<>();
        }

    }

    public  static Restaurant getRestaurant() {
         return restaurant;

    }

    public  static Staff registerStaff(Staff staff) throws Exception {

        if(restaurant.getCustomerDB().containsKey(staff.getEmail())) throw new Exception("Email already exists");

        restaurant.getStaffDB().put(staff.getEmail(), staff);
        return staff;
    }
    public  static Order createOrder(Order order) throws Exception {
restaurant.getOrderDB().put(order.getCustomerId(), order);


return order;

    }    public  static Booking createBooking(Booking booking, int capacity) throws Exception {
        booking.setTableId(getTableBySeatCount(capacity).getId());
restaurant.getBookingDB().put(booking.getCustomerId(), booking);


return booking;

    }

    public  static Menu createMenu(Menu menu) throws Exception {

        restaurant.getMenuDB().put(menu.getId(),menu);

return menu;

    }

    private  static Table getTableBySeatCount(int capacity) throws Exception {
for (Table t:restaurant.getTableDB().values()){
    if(t.getTotalCapacity() == capacity && t.getCurrentCapacity() != 0) return t;

}

throw new Exception("Table not currently available");


    }

    public static Stack<SceneNode> getSceneHistory() {
        return sceneHistory;
    }
    public static Customer getCustomerById(int id) {
        return restaurant.getCustomerDB().get( restaurant.getCustomerIdToUsernameDB().get(id));
    }
}
