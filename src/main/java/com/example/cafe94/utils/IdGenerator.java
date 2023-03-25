package com.example.cafe94.utils;

public class IdGenerator {
    private static int customerId = 1;
    private static int staffId = 1;
    private static int tableId = 1;
    private static int bookingId = 1;
    private static int menuId = 1;
    private static int orderId = 1;

    public static int generateCustomerId() {
        return customerId++;
    }

    public static int generateTableId() {
        return tableId++;
    }

    public static int generateStaffId() {
        return staffId++;
    }

    public static int generateMenuId() {
        return menuId++;
    }

    public static int generateOrderId() {
        return orderId++;
    }

    public static int generateBookingId() {
        return bookingId++;
    }
}
