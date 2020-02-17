package completion.service;

import java.util.concurrent.ThreadLocalRandom;

public class Cook {

    Restaurant restaurant;
    String name;

    public Cook(String name) {
        this.name = name;
    }

    public Plat prepareOrder(Order order) throws Exception {
        int randomNum = ThreadLocalRandom.current().nextInt(2000, 6000);
        System.out.println("Preparing Order nuber: " + order.orderNumber);
        Thread.sleep(randomNum);
        System.out.println(" Order nuber: " + order.orderNumber + " Prepared");
        return new Plat(new Food("This is food"), order);
    }

    public void enrolInRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        restaurant.cooks.offer(this);

    }
}
