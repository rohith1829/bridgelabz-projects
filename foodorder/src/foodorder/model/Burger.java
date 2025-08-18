package foodorder.model;

public class Burger extends FoodItem {
    public Burger(String name) { super(name); }
    public void prepare() { System.out.println("Preparing " + name); }
}