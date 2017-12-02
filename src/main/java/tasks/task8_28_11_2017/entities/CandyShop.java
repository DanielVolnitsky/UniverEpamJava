package tasks.task8_28_11_2017.entities;

import tasks.task8_28_11_2017.enumerations.NutrionalValue;

import java.util.List;
import java.util.Map;

public class CandyShop {
    private List<Candy> candies;
    private List<Ingredient> ingredients;
    private List<Map<NutrionalValue, Byte>> nutrionalValues;

    //     Прочитать данные из файла XML
    public void loadFromFile(String filename) {

    }
}
