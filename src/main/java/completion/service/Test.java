package completion.service;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {

        ExecutorService e = Executors.newCachedThreadPool();
        CompletionService cm = new ExecutorCompletionService(e);
        Restaurant restaurant = new Restaurant(cm);
        e.submit(restaurant);
        String cookName = "c1";
        createCook(restaurant, cookName);
        createCook(restaurant, "c2");
        createCook(restaurant, "c3");

        e.submit(() -> {
            int couter = 1;
            while (true) {
                try {
                    Customer c = new Customer("Customer" + couter++);
                    c.visitRestaurant(restaurant);
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private static void createCook(Restaurant restaurant, String cookName) {
        Cook cook1 = new Cook(cookName);
        cook1.enrolInRestaurant(restaurant);
    }
}
