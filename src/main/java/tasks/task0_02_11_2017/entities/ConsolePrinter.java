package tasks.task0_02_11_2017.entities;

import static tasks.task0_02_11_2017.entities.ConsolePrinterHelper.*;

/**
 * Класс служит для отрисовки геометрических фигур в консоль
 *
 * @author Daniel V.
 * @see ConsolePrinterHelper
 */
public class ConsolePrinter {

    /**
     * Отрисовывает прямугольник
     *
     * @param rowCount - кол-во строк матрицы, на которой будет отрисована фигура
     * @param colCount - кол-во столбцов матрицы, на которой будет отрисована фигура
     */
    public static void printRectangle(short rowCount, short colCount) {
        short rowsMaxIndex = (short) (rowCount - 1);
        short colsMaxIndex = (short) (colCount - 1);

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
    public static void printRightTriangle(short n) {
        short rowMaxIndex = (short) (n - 1);

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
     * @param - rowCount кол-во строк матрицы, на которой будет отрисована фигура
     * @param - colCount кол-во столбцов матрицы, на которой будет отрисована фигура
     */
    public static void printEquilateralTriangle(short rowCount, short colCount) {
        short rowsMaxIndex = (short) (rowCount - 1);
        short colsMaxIndex = (short) (colCount - 1);
        short shift = (short) (colCount / 2);

        for (short i = 0; i < rowCount; ++i) {
            for (short j = 0; j < colCount; ++j) {
                if (cellIsShifted(j, colsMaxIndex, shift) || cellIsBottomBound(i, rowsMaxIndex))
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
            --shift;
        }
    }

    /**
     * Отрисовывает ромб
     *
     * @param n - порядок матрицы, на которой будет отрисована фигура
     */
    public static void printRhombus(short n) {
        short colsMaxIndex = (short) (n - 1);

        /**InitShift - начальный сдвиг от краев матрицы, соответсвует вершине ромба*/
        short initShift = (short) (n / 2);
        /**shift - сдвиг изменяющийся, нужен для отрисовки точек ромба*/
        short shift = initShift;

        short counter = 0;

        for (short i = 0; i < n; ++i) {
            for (short j = 0; j < n; ++j) {
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
