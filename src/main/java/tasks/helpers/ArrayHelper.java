package tasks.helpers;

import tasks.task03_07_11_2017.interfaces.GeometricalObject;

/**
 * Класс хранит вспомогательные методы для работы с массивами
 *
 * @author Daniel V.
 */
public class ArrayHelper {

    public static void fillArrayByRandomizedInt(int[] arr, int min, int max) {
        max -= min;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + min;
        }
    }

    public static void swapTwoElements(int[] arr, int i, int j) {
        int buffer = arr[i];
        arr[i] = arr[j];
        arr[j] = buffer;
    }

    public static void swapTwoElements(double[] arr, int i, int j) {
        double buffer = arr[i];
        arr[i] = arr[j];
        arr[j] = buffer;
    }

    public static void swapTwoElements(GeometricalObject[] arr, int i, int j) {
       GeometricalObject buffer = arr[i];
        arr[i] = arr[j];
        arr[j] = buffer;
    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] != null)
                System.out.println(array[i].toString());
    }
}
