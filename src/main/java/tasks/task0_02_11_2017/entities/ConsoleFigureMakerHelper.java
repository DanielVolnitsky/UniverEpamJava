package tasks.task0_02_11_2017.entities;

/**
 * Класс содержит вспомогательные методы для класса отрисовки фигур в консоль:
 *
 * @author Daniel V.
 * @see ConsoleFigureMaker
 */
class ConsoleFigureMakerHelper {

    /**
     * Проверяет, принадлежит ли текущая позиция элемента любой из граней матрицы
     *
     * @param i            - текущий индекс строки
     * @param j            - текущий индекс столбца
     * @param rowsMaxIndex - максимальный индекс рядка матрицы
     */
    static boolean cellIsRectangleBound(int i, int j, int rowsMaxIndex, int colsMaxIndex) {
        return i == 0 || j == 0 || i == rowsMaxIndex || j == colsMaxIndex;
    }

    /**
     * Проверяет, принадлежит ли текущая позиция элемента побочной грани матрицы,
     * которая одновременно является стороной прямоугольного треугольника
     */
    static boolean cellIsRightSidelineTriangleBound(int i, int j, int rowsMaxIndex) {
        return i == rowsMaxIndex || j == 0 || i == j;
    }

    /**
     * Проверяет, принадлежит ли текущая позиция элемента одной из сторон равностороннего треугольника
     *
     * @param shift - значение текущего сдвига относительно краев матрицы
     */
    static boolean cellIsEquilateralRectangleBound(short i, short j, short rowsMaxIndex, short colsMaxIndex, short shift) {
        return i == rowsMaxIndex || cellIsShifted(j, colsMaxIndex, shift);
    }

    static boolean cellIsBottomBound(int i, int rowsMaxIndex) {
        return i == rowsMaxIndex;
    }

    /**
     * Проверяет, принадлежит ли текущая позиция элемента значению сдвига относительно краев матрицы
     *
     * @param shift - значение текущего сдвига относительно краев матрицы
     */
    static boolean cellIsShifted(int j, int colsMaxIndex, int shift) {
        return j == shift || j == colsMaxIndex - shift;
    }

    /**
     * Возвращает измененное значение сдвига от краев матрицы
     * Используется в метода отрисовки ромба
     *
     * @param shift - значение текущего сдвига относительно краев матрицы
     * @see ConsoleFigureMaker#printRhombus(short)
     */
    static int getChangedRhombusShift(int counter, int initShift, int shift) {
        return counter <= initShift ? --shift : ++shift;
    }
}
