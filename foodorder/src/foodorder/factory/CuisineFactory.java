package foodorder.factory;

import foodorder.model.*;

public abstract class CuisineFactory implements FoodFactory {
    @Override
    public FoodItem createFood(String type) {
        switch (type.toLowerCase()) {
            case "pizza": return createPizza();
            case "burger": return createBurger();
            case "drink": return createDrink();
            default: throw new IllegalArgumentException("Unknown food type");
        }
    }

    protected abstract FoodItem createPizza();
    protected abstract FoodItem createBurger();
    protected abstract FoodItem createDrink();
}