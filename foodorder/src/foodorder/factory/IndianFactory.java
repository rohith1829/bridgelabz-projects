package foodorder.factory;

import foodorder.model.*;

public class IndianFactory extends CuisineFactory {
    protected FoodItem createPizza() { return new Pizza("Indian Pizza"); }
    protected FoodItem createBurger() { return new Burger("Indian Burger"); }
    protected FoodItem createDrink() { return new Drink("Indian Drink"); }
}