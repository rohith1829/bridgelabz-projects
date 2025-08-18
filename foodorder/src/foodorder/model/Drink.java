package foodorder.model;

public class Drink extends FoodItem {
    public Drink(String name) { super(name); }
    public void prepare() { System.out.println("Pouring " + name); }
}