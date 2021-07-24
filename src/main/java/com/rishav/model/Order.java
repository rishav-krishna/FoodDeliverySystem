package com.rishav.model;

import java.util.List;
import java.util.Map;

public class Order {
    private int orderId;
    private Map<String,Integer> items;
    private int cost;

    public Order(int orderId, Map<String,Integer> items, int cost) {
        this.orderId = orderId;
        this.items = items;
        this.cost = cost;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Map<String,Integer> getItems() {
        return items;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
