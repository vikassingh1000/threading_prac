package completion.service;

public class Customer {

    String name;
    private Order order;
    private Plat plat;

    public Customer(String name) {
        this.name = name;
    }

    public void visitRestaurant(Restaurant restaurant) {
        restaurant.newCustomer(this);
    }

    public Order PlaceOrder() {
        return new Order();
    }

    public void receiveOrder(Plat plat) {

        this.plat = plat;
    }
}