package com.rishav.orderstrategy;

import com.rishav.model.Order;
import com.rishav.model.Restaurant;

import java.util.List;

public interface OrderFoodStrategy {
    public boolean orderFood(Order order, List<Restaurant> restaurantList);
}
