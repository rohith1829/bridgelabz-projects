package foodorder.strategy;

public class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using PayPal.");
    }
}