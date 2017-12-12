package tasks.task09_05_12_2017.beesAndPuch.entities;

import tasks.helpers.ArithmeticHelper;
import tasks.helpers.MatrixHelper;

public class Forest {
    final static byte RAND_POOH_LOCATION_MARK = 1;

    int length;
    int width;
    int[][] field;

    public Forest(int length, int width) throws IllegalArgumentException{
        setLength(length);
        setWidth(width);

        this.field = new int[length][width];
        initializeRandPoohLocation();
    }

    public void setLength(int length) throws IllegalArgumentException{
        if (length > -1)
            this.length = length;
        else
            throw new IllegalArgumentException("Длина не может быть отрицательна.");
    }

    public void setWidth(int width) throws IllegalArgumentException{
        if (width > -1)
            this.width = width;
        else
            throw new IllegalArgumentException("Ширина не может быть отрицательна.");
    }

    private void initializeRandPoohLocation() {
        int randLength = ArithmeticHelper.getRandomizedInt(0, length);
        int randWidth = ArithmeticHelper.getRandomizedInt(0, width);

        this.field[randLength][randWidth] = RAND_POOH_LOCATION_MARK;

        System.out.println("Поле:");
        MatrixHelper.printMatrix(field);
        System.out.println("\nРасположения Пуха: [" + randLength + ", " + randWidth + "]\n");
    }
}
