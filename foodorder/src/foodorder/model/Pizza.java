package foodorder.model;

public class Pizza extends FoodItem {
    public Pizza(String name) { super(name); }
    public void prepare() { System.out.println("Preparing " + name); }
}