package com.rishav.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Restaurant {
    private int id;
    private String name;
    private double rating;
    private Map<String,Integer> menu;
    private List<Order> orders;
    private int maxOrder;

    public Restaurant(int id, String name, double rating, Map<String, Integer> menu, int maxOrder) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.menu = menu;
        this.orders = new LinkedList<Order>();
        this.maxOrder = maxOrder;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public int getMaxOrder() {
        return maxOrder;
    }
}
