package com.rishav.orderstrategy;

import com.rishav.model.Order;
import com.rishav.model.Restaurant;

import java.util.List;
import java.util.Map;

public class LowestPriceStrategy implements OrderFoodStrategy{
    public boolean orderFood(Order order, List<Restaurant> restaurantList) {
        Restaurant dummyRestaurant = null;
        boolean allItemsAvailable = true;
        int cost = 0;
        int minCost = 100000;
        for (Restaurant restaurant : restaurantList){
            cost = 0;
            allItemsAvailable = true;
            if(restaurant.getOrders().size()==restaurant.getMaxOrder())
                continue;
            for(Map.Entry item: order.getItems().entrySet()){
                String dishName = (String) item.getKey();
                if(restaurant.getMenu().containsKey(dishName)){
                    int quantity = (int) item.getValue();
                    cost += (restaurant.getMenu().get(dishName))*quantity;
                }else{
                    allItemsAvailable = false;
                    break;
                }
            }
            if(allItemsAvailable){
                if(minCost>cost){
                    dummyRestaurant = restaurant;
                }
            }
        }
        if(dummyRestaurant!=null) {
            dummyRestaurant.getOrders().add(order);
            System.out.println("Order Placed at restaurant "+ dummyRestaurant.getName());
            return true;
        }
        return false;
    }
}
