package semaphore;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) throws Exception{


        Car h1 = new HatchBack("123");
        Car h2 = new HatchBack("321");
        Car h3 = new HatchBack("213");
        LinkedList cars = new LinkedList();
        cars.add(h1);
        cars.add(h2);
        cars.add(h3);
        Garage garage = new Garage(cars);
        ShowRoom showRoom = new ShowRoom(15, garage);
        Thread thread = new Thread(showRoom);
        thread.start();

        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);


        Thread.sleep(10000);
        System.out.println("New Customer arrived");
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);
        createCustomerAndVisit(showRoom);


    }

    private static void createCustomerAndVisit(ShowRoom showRoom) {
        Customer customer = new Customer(null);
        customer.visitShowRoom(showRoom);
    }
}
