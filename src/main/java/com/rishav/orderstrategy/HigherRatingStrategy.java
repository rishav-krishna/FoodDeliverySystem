package com.rishav.orderstrategy;

import com.rishav.model.Order;
import com.rishav.model.Restaurant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class HigherRatingStrategy implements OrderFoodStrategy{

    public boolean orderFood(Order order, List<Restaurant> restaurantList) {

        Collections.sort(restaurantList, (restaurant1,restaurant2) -> (restaurant1.getRating() > restaurant2.getRating()) ? -1:
                    (restaurant1.getRating() < restaurant2.getRating()) ? 1 : 0);

        boolean allItemsAvailable = true;
        int cost = 0;
        for (Restaurant restaurant : restaurantList){
            cost = 0;
            allItemsAvailable = true;
            if(restaurant.getOrders().size()==restaurant.getMaxOrder())
                continue;
            for(Map.Entry item: order.getItems().entrySet()){
                String dishName = (String) item.getKey();
                if(restaurant.getMenu().containsKey(dishName)){
                    int quantity = (int) item.getValue();
                    cost += restaurant.getMenu().get(dishName)*quantity;
                }else{
                    allItemsAvailable = false;
                    break;
                }
            }
            if(allItemsAvailable){
                restaurant.getOrders().add(order);
                System.out.println("Order Placed at restaurant "+ restaurant.getName());
                return true;
            }
        }
        return false;
    }


}
