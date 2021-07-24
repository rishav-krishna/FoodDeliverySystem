import com.rishav.exception.NoRestaurantCanFulfillOrder;
import com.rishav.model.Order;
import com.rishav.model.Restaurant;
import com.rishav.orderstrategy.OrderFoodStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RestaurantManger {
    private List<Restaurant> restaurants;
    private OrderFoodStrategy foodStrategy;
    private Map<Integer, Order> orderMap;

    public RestaurantManger() {
        restaurants = new ArrayList<Restaurant>();
        orderMap = new HashMap<>();
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public OrderFoodStrategy getFoodStrategy() {
        return foodStrategy;
    }

    public void setFoodStrategy(OrderFoodStrategy foodStrategy) {
        this.foodStrategy = foodStrategy;
    }

    public void orderFood(Order order){
        if(!foodStrategy.orderFood(order,restaurants)){
            throw new NoRestaurantCanFulfillOrder("All restaurants are busy!!");
        }else{
            orderMap.put(order.getOrderId(),order);
        }
    }


    public void updateRestaurant(String restaurantName, String operation, String item, int price) {
        List<Restaurant> restaurants = this.restaurants.stream().filter(restaurant -> restaurant.getName().equals(restaurantName)).collect(Collectors.toList());
        if(operation.equals("ADD")){
            restaurants.get(0).getMenu().put(item,price);
        }else{
            restaurants.get(0).getMenu().replace(item,price);
        }
        return;
    }

    public void updateOrder(String restaurantName, Integer orderId) {
        for(Restaurant restaurant:restaurants){
            if(restaurant.getName().equals(restaurantName)){
                Order order = orderMap.get(orderId);
                restaurant.getOrders().remove(order);
                System.out.println("Order "+orderId+" from restaurant "+ restaurantName +" is ready ");
            }
        }
    }
}
