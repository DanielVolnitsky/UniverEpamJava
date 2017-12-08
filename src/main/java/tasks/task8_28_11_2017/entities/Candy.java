package tasks.task8_28_11_2017.entities;

import tasks.task8_28_11_2017.enumerations.NutrionalValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Candy {

    private String id;
    private String name;
    private int caloricity;
    private CandyType candyType;
    private boolean hasFilling;
    private Manufacturer manufacturer;

    private List<Ingredient> ingredients;

    private Map<NutrionalValue, Double> nutrionalValues;

    {
        ingredients = new ArrayList<>();
        nutrionalValues = new HashMap<>();
    }

    public Candy() {

    }

    public Candy(String id, String name, byte caloricity, CandyType candyType, boolean hasFilling, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.caloricity = caloricity;
        this.candyType = candyType;
        this.hasFilling = hasFilling;
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<NutrionalValue, Double> getNutrionalValues() {
        return nutrionalValues;
    }

    public void setNutrionalValues(Map<NutrionalValue, Double> nutrionalValues) {
        this.nutrionalValues = nutrionalValues;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CandyType getCandyType() {
        return candyType;
    }

    public void setCandyType(CandyType candyType) {
        this.candyType = candyType;
    }

    public int getCaloricity() {
        return caloricity;
    }

    public void setCaloricity(int caloricity) {
        this.caloricity = caloricity;
    }

    public boolean hasFilling() {
        return hasFilling;
    }

    public void setHasFilling(boolean hasFilling) {
        this.hasFilling = hasFilling;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: '" + name + '\'' +
                ", caloricity: " + caloricity + " kkal" +
                ", type: " + candyType +
                ", filling: " + hasFilling +
                ", manufacturer: " + manufacturer +
                ", ingredients: " + ingredients +
                ", nutrionalValues: " + nutrionalValues +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (caloricity != candy.caloricity) return false;
        if (hasFilling != candy.hasFilling) return false;
        if (id != null ? !id.equals(candy.id) : candy.id != null) return false;
        if (name != null ? !name.equals(candy.name) : candy.name != null) return false;
        if (candyType != candy.candyType) return false;
        if (manufacturer != null ? !manufacturer.equals(candy.manufacturer) : candy.manufacturer != null) return false;
        if (ingredients != null ? !ingredients.equals(candy.ingredients) : candy.ingredients != null) return false;

        return nutrionalValues != null ? nutrionalValues.equals(candy.nutrionalValues) : candy.nutrionalValues == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + caloricity;
        result = 31 * result + (candyType != null ? candyType.hashCode() : 0);
        result = 31 * result + (hasFilling ? 1 : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        result = 31 * result + (nutrionalValues != null ? nutrionalValues.hashCode() : 0);
        return result;
    }

    public enum CandyType {
        CHOCOLATE, IRIS, CARAMEL, LOLLIPOP;
    }
}