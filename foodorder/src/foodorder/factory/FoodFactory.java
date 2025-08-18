package foodorder.factory;

import foodorder.model.FoodItem;

public interface FoodFactory {
    FoodItem createFood(String type);
}