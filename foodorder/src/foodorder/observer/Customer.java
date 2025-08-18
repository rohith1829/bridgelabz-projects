package foodorder.observer;

public class Customer implements Observer {
    private String name;

    public Customer(String name) { this.name = name; }

    @Override
    public void update(String status) {
        System.out.println(name + " notified: Order status -> " + status);
    }
}