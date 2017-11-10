package tasks.task0_02_11_2017.entities;

import tasks.helpers.MatrixHelper;

import static tasks.task0_02_11_2017.entities.ConsoleFigureMakerHelper.*;

/**
 * Класс служит для отрисовки геометрических фигур в консоль
 *
 * @author Daniel V.
 * @see ConsoleFigureMakerHelper
 */
public class ConsoleFigureMaker {

    /**
     * Отрисовывает прямугольник
     *
     * @param rowCount - кол-во строк матрицы, на которой будет отрисована фигура
     * @param colCount - кол-во столбцов матрицы, на которой будет отрисована фигура
     */
    public static void printRectangle(int rowCount, int colCount) {
        int rowsMaxIndex = rowCount - 1;
        int colsMaxIndex = colCount - 1;

        for (short i = 0; i < rowCount; ++i) {
            for (short j = 0; j < colCount; ++j) {
                if (cellIsRectangleBound(i, j, rowsMaxIndex, colsMaxIndex))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Отрисовывает прямугольный треугольник
     *
     * @param n - порядок матрицы, на которой будет отрисована фигура
     */
    public static void printRightTriangle(int n) {
        int rowMaxIndex = n - 1;
        for (short i = 0; i < n; ++i) {
            for (short j = 0; j < n; ++j) {
                if (cellIsRightSidelineTriangleBound(i, j, rowMaxIndex))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Отрисовывает равносторонний треугольник
     *
     * @param - colCount кол-во столбцов матрицы, на которой будет отрисована фигура; длина
     */
    public static String[][] getEquilateralTriangle(int colCount) {
        if (colCount % 2 != 0 && colCount > 0) {
            int shift = colCount / 2;
            String[][] canvas = new String[shift + 1][colCount];

            int colsMaxIndex = colCount - 1;
            int rowsMaxIndex = shift;

            for (int i = 0; i < canvas.length; ++i) {
                for (int j = 0; j < canvas[i].length; ++j) {
                    if (cellIsShifted(j, colsMaxIndex, shift) || cellIsBottomBound(i, rowsMaxIndex))
                        canvas[i][j] = "* ";
                    else
                        canvas[i][j] = "  ";
                }
                --shift;
            }
            return canvas;
        } else
            throw new IllegalArgumentException("To print eq. triangle figure you need to pass odd positive number of columns.");
    }

    public static String[][] getReversedEquilateralTriangle(int colCount) {
        try {
            return MatrixHelper.getInvertMatrix(getEquilateralTriangle(colCount));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("To print rhombus you need to pass odd positive number of columns");
        }
    }

    /**
     * Отрисовывает ромб при помощи создания двух равнобедренных трегуольников
     *
     * @param - colCount кол-во столбцов матрицы, на которой будет отрисована фигура; длина
     * @see ConsoleFigureMaker#getEquilateralTriangle(int)
     * @see ConsoleFigureMaker#getReversedEquilateralTriangle(int)
     */
    public static String[][] getRhombusBy2Triangles(int colCount) {

        /*eq. triangle*/
        String[][] etr = getEquilateralTriangle(colCount);
        /*reversed eq. triangle*/
        String[][] retr = getReversedEquilateralTriangle(colCount);

        /*холст для ромба*/
        String[][] canvas = new String[etr.length * 2 - 1][colCount];

        /*рисует равнобед. треугольник сверху холста*/
        for (int i = 0; i < etr.length; i++)
            for (int j = 0; j < etr[0].length; j++)
                canvas[i][j] = etr[i][j];

        /*дорисовывает равнобед. превернутый треугольник снизу холста*/
        for (int i1 = retr.length - 1, i2 = canvas.length - 1; i1 > 0; i1--, i2--)
            for (int j = 0; j < retr[0].length; j++)
                canvas[i2][j] = retr[i1][j];

        return canvas;
    }

    /**
     * Отрисовывает ромб
     *
     * @param n - порядок матрицы, на которой будет отрисована фигура
     */
    public static void printRhombus(int n) {
        int colsMaxIndex = n - 1;

        /**InitShift - начальный сдвиг от краев матрицы, соответсвует вершине ромба*/
        int initShift = n / 2;
        /**shift - сдвиг изменяющийся, нужен для отрисовки точек ромба*/
        int shift = initShift;
        int counter = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (cellIsShifted(j, colsMaxIndex, shift))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
            shift = getChangedRhombusShift(++counter, initShift, shift);
        }
    }
}
