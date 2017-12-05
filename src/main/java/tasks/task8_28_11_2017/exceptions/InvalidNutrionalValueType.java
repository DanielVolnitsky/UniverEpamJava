package tasks.task8_28_11_2017.exceptions;

public class InvalidNutrionalValueType extends Exception {

    @Override
    public String getMessage() {
        return "No such nutrional value type exists. There is only fats, proteins and carbohydates in the nature";
    }
}
