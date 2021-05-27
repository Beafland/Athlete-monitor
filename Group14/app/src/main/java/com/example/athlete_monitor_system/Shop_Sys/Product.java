package com.example.athlete_monitor_system.Shop_Sys;

import java.io.Serializable;

public class Product implements Serializable {
    String name;
    String price;
    String id;
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public Product(String name, String price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
