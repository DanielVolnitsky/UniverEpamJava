package tasks.task01_03_11_2017.arraysAndMatrices.entities;

enum Direction {
    RIGHT, LEFT, TOP, BOTTOM
}

/**
 * Класс служит для нестандартных обходов элементов матрицы
 *
 * @author Daniel
 */
public class MatrixBypasser {

    private static int[][] matrix;

    /**
     * занчение, показывающее, сколько значений должно перебраться на текущем шаге
     */
    private static int moveCount;

    /**
     * индекс текущего рядка
     */
    private static int row = 0;

    /**
     * индекс текущего столбца
     */
    private static int col = 0;

    /**
     * индекс вставляемого элемента в результирующий массив
     */
    private static int inserted = 0;

    public MatrixBypasser(int[][] matrix) {
        setMatrix(matrix);
        moveCount = this.matrix.length;
    }

    private static void nullifyInitialValues() {
        row = col = inserted = 0;
        moveCount = matrix.length;
    }

    private static void moveRight(int[] result) {
        for (int j = col, c = 0; c < moveCount; j++, c++) {
            result[inserted++] = matrix[row][j];
            col = j;
        }
    }

    private static void moveLeft(int[] result) {
        for (int j = col, c = 0; c < moveCount; j--, c++) {
            result[inserted++] = matrix[row][j];
            col = j;
        }
    }

    private static void moveBottom(int[] result) {
        for (int i = row, c = 0; c < moveCount; i++, c++) {
            result[inserted++] = matrix[i][col];
            row = i;
        }
    }

    private static void moveTop(int[] result) {
        for (int i = row, c = 0; c < moveCount; i--, c++) {
            result[inserted++] = matrix[i][col];
            row = i;
        }
    }

    private void setMatrix(int[][] matrix) {
        if (matrix.length == matrix[0].length)
            this.matrix = matrix;
        else
            throw new IllegalArgumentException("Matrix has to be squared");
    }

    /**
     * Метод выполняет обход и запись элементов матрицы по часовой стрелке,
     * основывается на технологии конечного автомата,
     * в зависимости от состояния направления выполняет проход по соответствующим элементам.
     *
     * @return Возвращает массив элементов, взятых по часовой стрелке после обхода матрицы
     */
    public int[] bypassMatrixClockwise() {

        int n = matrix.length;
        if (n % 2 != 0) {
            int[] result = new int[n * n];

            Direction direction = Direction.RIGHT;

            while (moveCount > 0) {
                switch (direction) {
                    case RIGHT:
                        moveRight(result);
                        row++;
                        moveCount--;
                        direction = Direction.BOTTOM;
                        break;
                    case LEFT:
                        moveLeft(result);
                        row--;
                        moveCount--;
                        direction = Direction.TOP;
                        break;
                    case TOP:
                        moveTop(result);
                        col++;
                        direction = Direction.RIGHT;
                        break;
                    case BOTTOM:
                        moveBottom(result);
                        col--;
                        direction = Direction.LEFT;
                        break;
                }
            }
            nullifyInitialValues();
            return result;
        } else
            throw new IllegalArgumentException("Matrix's 'm' must be odd.");
    }
}

