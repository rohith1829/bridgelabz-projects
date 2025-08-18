package foodorder.factory;

import foodorder.model.*;

public class ItalianFactory extends CuisineFactory {
    protected FoodItem createPizza() { return new Pizza("Italian Pizza"); }
    protected FoodItem createBurger() { return new Burger("Italian Burger"); }
    protected FoodItem createDrink() { return new Drink("Italian Drink"); }
}