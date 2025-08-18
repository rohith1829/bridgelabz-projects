package foodorder.model;

public abstract class FoodItem {
    protected String name;

    public FoodItem(String name) {
        this.name = name;
    }

    public abstract void prepare();

    @Override
    public String toString() {
        return name;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}