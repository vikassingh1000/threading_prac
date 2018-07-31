package semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShowRoom implements Runnable {

    private BlockingQueue<Customer> customers;
    private Garage garage;

    public ShowRoom(int cusomerCap, Garage garage) {
        this.customers = new ArrayBlockingQueue<Customer>(cusomerCap);
        this.garage = garage;
    }

    @Override
    public void run() {
        System.out.println("Show room is opened...");
        try {
            while (true) {
                System.out.println("Waiting for Customer to come");
                Customer customer = customers.poll(Long.MAX_VALUE, TimeUnit.HOURS);
                System.out.println("Waiting for car to free");
                Car car = garage.carAvailable();
                customer.driverAndPark(car);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public boolean newCustomerArrived(Customer customer) {
        return customers.offer(customer);
    }

    public Garage getGarage() {
        return garage;
    }
}
