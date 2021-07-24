package com.rishav.model;

import java.util.Map;

public class Inventory<T> {
    private Map<T,Integer> map;

    public Inventory(){
        map = (Map<T, Integer>) new Inventory<T>();
    }
}
