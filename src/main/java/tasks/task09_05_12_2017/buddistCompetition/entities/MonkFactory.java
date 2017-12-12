package tasks.task09_05_12_2017.buddistCompetition.entities;

import static tasks.helpers.ArithmeticHelper.getRandomizedInt;

public class MonkFactory {
    private static final int MAX_CHI_POSSIBLE = 100;

    public static Monk getNextMonk() {
        return new Monk(getRandomizedInt(0, MAX_CHI_POSSIBLE));
    }
}
