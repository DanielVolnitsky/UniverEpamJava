package tasks.helpers;

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

    /**
     * Сортирует отрицательные числа по возрастанию
     */
    public static void sortNegativesAscending(int[] arr) {
        InsertionSortNegativesAscending(arr);
    }

    /**
     * Сортирует положительные числа по спаданию
     */
    public static void sortPositivesDescending(int[] arr) {
        InsertionSortPositivesDescending(arr);
    }

    /**
     * Модифицированная сортировка вставками для положительных чисел (по спаданию)
     */
    private static void InsertionSortPositivesDescending(int[] arr) {
        int n = arr.length;
        int i, j;
        if (n > 1) {
            for (i = n - 2; arr[i] > 0; i--) {
                int temp = arr[i];
                j = i;
                while (j < n - 1 && arr[j + 1] >= temp) {
                    arr[j] = arr[j + 1];
                    j++;
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * Модифицированная сортировка вставками для отрицательных чисел (по возрастанию)
     */
    private static void InsertionSortNegativesAscending(int arr[]) {
        int n = arr.length;
        int i, j;
        if (n > 1) {
            for (i = 1; i < n; i++) {
                if (arr[i] < 0) {
                    int temp = arr[i];
                    j = i;
                    while (j > 0 && (arr[j - 1] > 0 || arr[j - 1] >= temp)) {
                        arr[j] = arr[j - 1];
                        j--;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                System.out.println(array[i].toString());
        }
    }
}
