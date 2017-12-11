package tasks.task10_07_12_2017.entities;

import tasks.exceptions.InvalidIdException;
import tasks.exceptions.InvalidTimeValueException;
import tasks.task10_07_12_2017.entities.abstractions.RunnableTransportFactory;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class RunnableСarFactory extends RunnableTransportFactory {
    /*мс*/
    protected final int MAX_TIME_WAITING = 2000;
    /*мс*/
    protected final int MAX_TIME_AT_PARKING = 2000;
    protected final int MAX_ID = 2000;

    @Override
    public RunnableCar getRunnableTransport() {
        try {
            return new RunnableCar(getRandomizedInt(0, MAX_ID), getRandomizedInt(0, MAX_TIME_WAITING), getRandomizedInt(0, MAX_TIME_AT_PARKING));
        } catch (InvalidIdException | InvalidTimeValueException e) {
            System.out.println("Проблемы с разработкой машины, делаем другую");
            return getRunnableTransport();
        }
    }
}
