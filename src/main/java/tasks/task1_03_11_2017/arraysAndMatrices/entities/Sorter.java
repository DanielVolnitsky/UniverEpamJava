package tasks.task1_03_11_2017.arraysAndMatrices.entities;

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
        ArrayHelper.sortNegativesAscending(arr);
        ArrayHelper.sortPositivesDescending(arr);
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
        MatrixHelper.changeMatrixColumnsByArrayValuesDescendingly(matrix, averages);
    }

    /**
     * Упорядочивает строки по возрастанию, по самой длинной серии одинаковых элементов.
     */
    public static void sortRowsByLongestSeries(int[][] matrix) {

        /**Хранит значение самой длинной серии элементов строк матрицы*/
        int[] longestSeries = new int[matrix.length];

        MatrixHelper.fillLongestSeriesArray(longestSeries, matrix);
        MatrixHelper.changeMatrixRowsByArrayValues(matrix, longestSeries);
    }
}

