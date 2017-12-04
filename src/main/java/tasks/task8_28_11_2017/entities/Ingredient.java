package tasks.task8_28_11_2017.entities;

public class Ingredient {

    private double quantity;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String ingredientDescription) {
        this.description = ingredientDescription;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "[description: " + description + ", quantity: " + quantity + " mg" + "]";
    }
}
