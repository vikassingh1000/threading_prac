package completion.service;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    static final AtomicInteger orderNumberCounter = new AtomicInteger(0);
    int orderNumber;

    public Order() {
        this.orderNumber = orderNumberCounter.incrementAndGet();
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
