package tasks.task8_28_11_2017.entities;

import tasks.task8_28_11_2017.enumerations.NutrionalValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Candy {

    private int id;
    private String name;
    private int caloricity;
    private CandyType candyType;
    private boolean hasFilling;
    private Manufacturer manufacturer;

    private List<Ingredient> ingredients;

    private Map<NutrionalValue, Byte> nutrionalValues;

    {
       ingredients = new ArrayList<>();
       nutrionalValues = new HashMap<>();
    }

    public Candy() {

    }

    public Candy(int id, String name, byte caloricity, CandyType candyType, boolean hasFilling, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.caloricity = caloricity;
        this.candyType = candyType;
        this.hasFilling = hasFilling;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<NutrionalValue, Byte> getNutrionalValues() {
        return nutrionalValues;
    }

    public void setNutrionalValues(Map<NutrionalValue, Byte> nutrionalValues) {
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

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", caloricity=" + caloricity +
                ", candyType=" + candyType +
                ", hasFilling=" + hasFilling +
                ", manufacturer=" + manufacturer +
                ", ingredients=" + ingredients +
                ", nutrionalValues=" + nutrionalValues +
                '}';
    }

    public enum CandyType {
        CHOCOLATE, IRIS(false), CARAMEL, LOLLIPOP(false);

        private boolean hasFilling;

        CandyType() {

        }

        CandyType(boolean hasFilling) {
            this.hasFilling = hasFilling;
        }
    }
}