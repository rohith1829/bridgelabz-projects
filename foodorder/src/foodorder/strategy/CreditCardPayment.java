package foodorder.strategy;

public class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card.");
    }
}