package tasks.task09_05_12_2017.beesAndPuch.entities;

import tasks.helpers.ArithmeticHelper;
import tasks.helpers.MatrixHelper;

public class Forest {
    final static byte RAND_POOH_LOCATION = 1;

    int length;
    int width;
    int[][] field;

    public Forest(int length, int width) {
        this.length = length;
        this.width = width;

        this.field = new int[length][width];
        initializeRandPoohLocation();
    }

    private void initializeRandPoohLocation() {
        int randLength = ArithmeticHelper.getRandomizedInt(0, length);
        int randWidth = ArithmeticHelper.getRandomizedInt(0, width);

        this.field[randLength][randWidth] = RAND_POOH_LOCATION;

        System.out.println("Поле:");
        MatrixHelper.printMatrix(field);
        System.out.println("\nРасположения Пуха: [" + randLength + ", " + randWidth + "]\n");
    }
}
