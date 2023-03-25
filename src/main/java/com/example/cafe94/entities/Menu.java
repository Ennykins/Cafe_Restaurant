package com.example.cafe94.entities;


import com.example.cafe94.utils.IdGenerator;

public class Menu {

    private int id;
    private String name;

    public Menu() {

        id = IdGenerator.generateMenuId();
    }

    public Menu(String name) {

        id = IdGenerator.generateMenuId();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
