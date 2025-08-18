package foodorder;

import foodorder.db.FoodDB;

import foodorder.factory.FoodFactory;
import foodorder.factory.IndianFactory;
import foodorder.factory.ItalianFactory;
import foodorder.model.FoodItem;
import foodorder.observer.Customer;
import foodorder.observer.OrderTracker;
import foodorder.order.FoodOrder;
import foodorder.strategy.CreditCardPayment;
import foodorder.strategy.PayPalPayment;
import foodorder.strategy.PaymentStrategy;
import foodorder.strategy.UPIPayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Singleton Test
        FoodDB db1 = FoodDB.getInstance();
        FoodDB db2 = FoodDB.getInstance();
        System.out.println("Database connected.");
        System.out.println("Same DB instance: " + (db1 == db2));

        System.out.println("\nWelcome to Food Ordering System!");
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        Customer customer = new Customer(customerName);

        // Choose cuisine
        System.out.println("\nChoose Cuisine: ");
        System.out.println("1. Italian");
        System.out.println("2. Indian");
        int cuisineChoice = sc.nextInt();

        FoodFactory factory;
        if (cuisineChoice == 1) {
            factory = new ItalianFactory();
        } else if (cuisineChoice == 2) {
            factory = new IndianFactory();
        } else {
            System.out.println("Invalid cuisine choice. Exiting.");
            return;
        }

        // Choose items
        List<FoodItem> items = new ArrayList<>();
        sc.nextLine(); // clear buffer
        while (true) {
            System.out.println("\nSelect Item (type name): pizza / burger / drink");
            System.out.println("Type 'done' to finish order.");
            String itemChoice = sc.nextLine().toLowerCase();

            if (itemChoice.equals("done")) break;

            try {
                FoodItem item = factory.createFood(itemChoice);
                System.out.println("Preparing " + item.getName());
                items.add(item);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice!");
            }
        }

        System.out.print("\nEnter any special note (or press Enter to skip): ");
        String note = sc.nextLine();

        // Create FoodOrder
        FoodOrder order = new FoodOrder(items, note);

        // Observer pattern
        OrderTracker tracker = new OrderTracker();
        tracker.addObserver(customer);
        tracker.updateStatus("Order Received");
        tracker.updateStatus("Cooking");
        tracker.updateStatus("Delivered");

        // Choose payment strategy
        System.out.println("\nChoose Payment Method: ");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. PayPal");
        int payChoice = sc.nextInt();
        sc.close();
        PaymentStrategy paymentStrategy;
        switch (payChoice) {
            case 1 -> paymentStrategy = new UPIPayment();
            case 2 -> paymentStrategy = new CreditCardPayment();
            case 3 -> paymentStrategy = new PayPalPayment();
            default -> {
                System.out.println("Invalid payment choice. Exiting.");
                return;
            }
        }

        paymentStrategy.pay(500); // fixed demo amount
        
    }
}
