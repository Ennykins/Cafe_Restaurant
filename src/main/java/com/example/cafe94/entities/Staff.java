package com.example.cafe94.entities;

import com.example.cafe94.enums.StaffType;
import com.example.cafe94.utils.IdGenerator;


public class Staff {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private StaffType type = StaffType.MANAGER;
    private int hoursToWork = 0;
    private int totalHoursWorked = 0;

    public Staff(){
        id = IdGenerator.generateStaffId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StaffType getType() {
        return type;
    }

    public void setType(StaffType type) {
        this.type = type;
    }

    public int getHoursToWork() {
        return hoursToWork;
    }

    public void setHoursToWork(int hoursToWork) {
        this.hoursToWork = hoursToWork;
    }

    public int getHoursWorked() {
        return totalHoursWorked;
    }

    public void setHoursWorked(int totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }
}
