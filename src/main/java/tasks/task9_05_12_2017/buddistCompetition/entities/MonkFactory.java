package tasks.task9_05_12_2017.buddistCompetition.entities;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class MonkFactory {
    public static Monk getNextMonk() {
        return new Monk(getRandomizedInt(0, 100));
    }
}
