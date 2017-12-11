package tasks.task01_03_11_2017.arraysAndMatrices.entities;

import tasks.helpers.ArrayHelper;
import tasks.helpers.MatrixHelper;

/**
 * Класс служит для сортировок, затребованных заданием 2 домашней работы
 *
 * @author Daniel V.
 * @see ArrayHelper
 * @see MatrixHelper
 */
public class Sorter {

    /**
     * Упорядочивает в одномерном массиве вначале отрицательные элементы по возрастанию,
     * затем положительные по убыванию.
     */
    public static void sortNegativesAscendingPositiveDescending(int[] arr) {
        sortNegativesAscending(arr);
        sortPositivesDescending(arr);
    }

    /**
     * В одномерном массиве сортирует элементы так, чтоб в начале массива
     * оказались положительные потом отрицательные за О (n).
     */
    public static void sortPositiveThenNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    if (arr[j] >= 0) {
                        ArrayHelper.swapTwoElements(arr, i, j);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Упорядочивает столбцы матрицы по убыванию среднего значения.
     */
    public static void sortColumnsByAverageValueDescending(int[][] matrix) {

        /**Хранит средние значения столбцов матрицы*/
        double[] averages = new double[matrix[0].length];

        MatrixHelper.fillArrayOfMatrixColAverages(averages, matrix);
        columnsSelectionSortByArrayDescending(matrix, averages);
    }

    /**
     * Упорядочивает строки по возрастанию, по самой длинной серии одинаковых элементов.
     */
    public static void sortRowsByLongestSeries(int[][] matrix) {

        /**Хранит значение самой длинной серии элементов строк матрицы*/
        int[] longestSeries = new int[matrix.length];

        MatrixHelper.fillLongestSeriesArray(longestSeries, matrix);
        rowsSelectionSortByArrayAscendingly(matrix, longestSeries);
    }

    /**
     * Сортирует отрицательные числа по возрастанию
     */
    private static void sortNegativesAscending(int[] arr) {
        InsertionSortNegativesAscending(arr);
    }

    /**
     * Сортирует положительные числа по спаданию
     */
    private static void sortPositivesDescending(int[] arr) {
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

    /**
     * Сортировка столбцов с помощью selection sort
     *
     * @param matrix - матрица, в которой меняются столбцы, в зависимости от сортировки параметра arr
     * @param arr    - массив, по которому длеается сравнение
     */
    public static void columnsSelectionSortByArrayDescending(int[][] matrix, double[] arr) {
        int max;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            max = i;
            for (int j = i; j < n; j++) {
                if (arr[j] > arr[max])
                    max = j;
            }
            ArrayHelper.swapTwoElements(arr, i, max);
            MatrixHelper.swapTwoColumns(matrix, i, max);
        }
    }

    /**
     * Сортировка рядков матрицы с помощью selection sort
     *
     * @param matrix - матрица, в которой меняются рядки, в зависимости от сортировки параметра arr
     * @param arr    - массив, по которому длеается сравнение
     */
    private static void rowsSelectionSortByArrayAscendingly(int[][] matrix, int[] arr) {
        int min;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            ArrayHelper.swapTwoElements(arr, i, min);
            MatrixHelper.swapTwoRows(matrix, i, min);
        }
    }
}

