package com.example.cafe94.entities;


import com.example.cafe94.utils.IdGenerator;

public class Table {
    private int id;
    private boolean[] filled ;
    private int filledIndex = 0;


    public Table(int seats) {
        filled = new boolean[seats];
        id = IdGenerator.generateTableId();
    }

    public int getTotalCapacity() {
        return filled.length;
    }

    public int getCurrentCapacity() {
        return filled.length - filledIndex;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
