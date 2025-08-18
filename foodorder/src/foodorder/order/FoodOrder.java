package foodorder.order;

import foodorder.model.FoodItem;
import java.util.*;

public class FoodOrder {
    private List<FoodItem> items;
    private String note;

    private FoodOrder(Builder builder) {
        this.items = builder.items;
        this.note = builder.note;
    }

    public FoodOrder(List<FoodItem> items, String note) {
		this.items=items;
		this.note=note;
	}

	public static class Builder {
        List<FoodItem> items = new ArrayList<>();
        String note;

        public Builder addItem(FoodItem item) {
            items.add(item);
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public FoodOrder build() { return new FoodOrder(this); }
    }

    @Override
    public String toString() {
        return "Order: " + items + (note != null ? ", Note: " + note : "");
    }
}