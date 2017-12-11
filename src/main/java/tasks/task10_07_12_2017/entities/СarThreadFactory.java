package tasks.task10_07_12_2017.entities;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class СarThreadFactory {
    public static CarThread getNextCar(){
        return new CarThread(getRandomizedInt(0, 1000), getRandomizedInt(0, 2000), getRandomizedInt(0, 2000));
    }
}
