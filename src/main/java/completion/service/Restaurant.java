package completion.service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Restaurant implements Runnable {

    Queue<Cook> cooks = new LinkedList<>();

    CompletionService<Cook> staffCompletionService;
    BlockingQueue<Customer> customerConcurrentLinkedQueue = new LinkedBlockingQueue<Customer>();
    ConcurrentLinkedQueue<Plat> platConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    ConcurrentHashMap<Integer, Customer> orderIdToCustomer = new ConcurrentHashMap();

    public Restaurant(CompletionService<Cook> staffCompletionService) {
        this.staffCompletionService = staffCompletionService;
    }


    @Override
    public void run() {
        try {
            System.out.println("Restaurant open...@@@@@");
            while (true) {

                Customer customer = customerConcurrentLinkedQueue.take();
                Order order = customer.PlaceOrder();
                System.out.println(String.format("New Order no %s,  from %s customer placed ", order.orderNumber, customer.name));
                orderIdToCustomer.put(order.getOrderNumber(), customer);
                Cook s = cooks.poll();
                staffCompletionService.submit(() -> {
                    Plat p = s.prepareOrder(order);
                    Customer customer1 = orderIdToCustomer.get(p.order.getOrderNumber());
                    customer1.receiveOrder(p);
                    System.out.println(String.format("Customer %s has received the Order %s", customer.name, order.orderNumber));
                    return s;
                });
                Cook cook = staffCompletionService.take().get();
                cooks.offer(cook);

            }
        } catch (InterruptedException | ExecutionException ie) {
            ie.printStackTrace();
        }
    }

    public void newCustomer(Customer customer) {
        System.out.println("New Customer came" + customer.name);
        customerConcurrentLinkedQueue.offer(customer);
    }


}
