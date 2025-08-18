package foodorder.db;

public class FoodDB {
    private static FoodDB instance;

    private FoodDB() {
        System.out.println("Database connected.");
    }

    public static FoodDB getInstance() {
        if (instance == null) {
            instance = new FoodDB();
        }
        return instance;
    }
}