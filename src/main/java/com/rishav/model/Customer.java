package com.rishav.model;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;

    public Customer(String name) {
        id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
