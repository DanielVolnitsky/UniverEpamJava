package tasks.helpers;

import tasks.task01_03_11_2017.arraysAndMatrices.entities.Sorter;

/**
 * Класс хранит вспомогательные методы для работы с матрицами
 *
 * @author Daniel V.
 * @see Sorter;
 */
public class MatrixHelper {

/*    public static void printMatrix(Object[][] matrix) {
        if(matrix != null){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }*/

    public static void printMatrix(int[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static String[][] getInvertMatrix(String[][] matrix) {
        for (int i1 = 0, i2 = matrix.length - 1; i1 < i2; i1++, i2--) {
            for (int j = 0; j < matrix[i1].length; j++) {
                String buffer = matrix[i1][j];
                matrix[i1][j] = matrix[i2][j];
                matrix[i2][j] = buffer;
            }
        }
        return matrix;
    }

    public static void fillMatrixByRandomizedInt(int[][] matrix, int min, int max) {
        max -= min;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = (int) (Math.random() * max) + min;
        }
    }

    public static void swapTwoRows(int[][] matr, int row1Index, int row2Index) {
        for (int i = 0; i < matr.length; i++) {
            if (i == row1Index) {
                for (int j = 0; j < matr[i].length; j++) {
                    int buffer = matr[i][j];
                    matr[i][j] = matr[row2Index][j];
                    matr[row2Index][j] = buffer;
                }
            }
        }
    }

    public static void swapTwoColumns(int[][] matr, int col1Index, int col2Index) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (j == col1Index) {
                    int buffer = matr[i][j];
                    matr[i][j] = matr[i][col2Index];
                    matr[i][col2Index] = buffer;
                }
            }
        }
    }

    /**
     * Заполняет массив средними значениями столбцов матрицы
     *
     * @see Sorter#sortColumnsByAverageValueDescending(int[][])
     */
    public static void fillArrayOfMatrixColAverages(double[] averages, int[][] matr) {
        int rowsCount = matr.length;
        int colsCount = matr[0].length;

        for (int j = 0; j < colsCount; j++) {
            int sum = 0;
            for (int i = 0; i < rowsCount; i++) {
                sum += matr[i][j];
            }
            averages[j] = (double) sum / rowsCount;
        }
    }

    /**
     * Заполняет массив значениями самых длинных серий элементов строк матрицы
     *
     * @see Sorter#sortRowsByLongestSeries(int[][])
     */
    public static void fillLongestSeriesArray(int[] longestSeries, int[][] matrix) {
        if (matrix.length > 1 && matrix[0].length > 1) {
            for (int i = 0; i < matrix.length; i++) {
                int seriesValue = matrix[i][0];
                int seriesSum = 1;
                int longestSum = 1;
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] == seriesValue)
                        seriesSum++;
                    else {
                        seriesValue = matrix[i][j];
                        if (seriesSum > longestSum)
                            longestSum = seriesSum;
                        seriesSum = 1;
                    }
                }
                longestSeries[i] = longestSum;
            }
        }
    }
}

