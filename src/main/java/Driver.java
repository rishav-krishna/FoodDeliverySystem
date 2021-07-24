import com.rishav.model.Customer;
import com.rishav.model.Order;
import com.rishav.model.Restaurant;
import com.rishav.orderstrategy.HigherRatingStrategy;
import com.rishav.orderstrategy.LowestPriceStrategy;
import com.rishav.orderstrategy.OrderFoodStrategy;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        RestaurantManger restaurantManger = new RestaurantManger();
        Map<String,UUID> customerBase = new HashMap<>();
        OrderFoodStrategy highestRatingStrategy = new HigherRatingStrategy();
        OrderFoodStrategy lowestPriceStrategy = new LowestPriceStrategy();
        String restaurantName;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            String Command=scanner.nextLine();
            String [] Commands=Command.split(" ");
            String CommandType=Commands[0];
            switch (CommandType) {
                case "ONBOARD":
                    restaurantName = Commands[1];
                    Integer maxOrders = Integer.parseInt(Commands[2]);
                    Map<String, Integer> menu = new HashMap<>();
                    Integer totalItems = Integer.parseInt(Commands[3]);
                    for (int i = 0; i < totalItems; i++) {
                        String dishName = Commands[4 + 2*i];
                        Integer price = Integer.parseInt(Commands[4 + 2*i + 1]);
                        menu.put(dishName, price);
                    }
                    Double rating = Double.parseDouble(Commands[4 + 2 * totalItems]);
                    restaurantManger.getRestaurants().add(new Restaurant(1, restaurantName, rating, menu, maxOrders));
                    break;
                case "ORDER":
                    try {
                        Integer orderId = Integer.parseInt(Commands[1]);
                        String name = Commands[2];
                        Integer numberOfItems = Integer.parseInt(Commands[3]);
                        Map<String, Integer> items = new HashMap<>();
                        for (int i = 0; i < numberOfItems; i++) {
                            String dishName = Commands[4 + 2*i];
                            Integer quantity = Integer.parseInt(Commands[4 + 2*i + 1]);
                            items.put(dishName, quantity);
                        }
                        String foodStrategy = Commands[4 + 2*numberOfItems];
                        if (foodStrategy.equals("HIGHEST_RATING")) {
                            restaurantManger.setFoodStrategy(highestRatingStrategy);
                        } else {
                            restaurantManger.setFoodStrategy(lowestPriceStrategy);
                        }
                        restaurantManger.orderFood(new Order(orderId, items, 0));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "UPDATE_MENU":
                    restaurantName = Commands[1];
                    String operation = Commands[2];
                    String item = Commands[3];
                    int price = Integer.parseInt(Commands[4]);
                    restaurantManger.updateRestaurant(restaurantName, operation, item, price);
                    break;
                case "UPDATE_ORDER":
                    restaurantName = Commands[1];
                    Integer orderId = Integer.parseInt(Commands[2]);
                    restaurantManger.updateOrder(restaurantName, orderId);
                    break;
            }
        }

    }
}
