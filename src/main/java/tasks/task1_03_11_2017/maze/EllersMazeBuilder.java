package tasks.task1_03_11_2017.maze;

import java.util.Random;

public class EllersMazeBuilder {
    private static final String WALL = "@ ";
    private static final String FREE_PATH = "  ";
    private static final int UNDETERMINED = -2;
    private static final int WALL_BETWEEN_SETS = -1;

    private String[][] field;

    private int rows, cols;

    /*Кол-во рядков и строк*/
    private int currRow, currCol;

    //текущая и следующая за ней строки (за исключением боковых стен)
    private int[] currentRow, nextRow;

    /*Кол-во множеств в строке*/
    private int setsCount;

    /*множества, которые будут затирать соседние*/
    private int dominativeSet, dominativeSet2;

    private Random rand;

    public EllersMazeBuilder(int nRows, int nCols) {
        currRow = nRows;
        currCol = nCols;

        rows = currRow * 2 + 1;
        cols = currCol * 2 + 1;

        field = new String[rows][cols];
        currentRow = new int[currCol * 2 - 1];
        nextRow = new int[currCol * 2 - 1];

        /**Заполняет поле стенами*/
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[0].length; j++)
                field[i][j] = WALL;

        /**Заполняет следующую строку неопределенными элементами*/
        for (int i = 0; i < nextRow.length; i++)
            nextRow[i] = UNDETERMINED;

        /** Инициализация первой строки неповторяющимися множествами*/
        for (int i = 0; i < currentRow.length; i += 2) {
            currentRow[i] = i / 2 + 1;
            if (i != currentRow.length - 1)
                currentRow[i + 1] = WALL_BETWEEN_SETS;
        }
        setsCount = currentRow[currentRow.length - 1];
    }

    public String[][] getMaze() {
        return field;
    }

    /**
     * Генерирует лабиринт алгоритмом Эйлера
     */
    public void buildMaze() {

        rand = new Random();
        for (int i = 0; i < currRow - 1; i++) {   //для всех строк кроме последней
            if (i != 0) {
                /*получаем текущую строку из последней итерации*/
                for (int j = 0; j < currentRow.length; j++) {
                    currentRow[j] = nextRow[j];
                    nextRow[j] = UNDETERMINED;
                }
            }

            joinSets();
            makeVerticalPasses();

            /* заполняет пустую часть следующей строки новыми множествами*/
            for (int j = 0; j < currentRow.length; j += 2) {
                if (nextRow[j] == UNDETERMINED)
                    nextRow[j] = ++setsCount;

                if (j != currentRow.length - 1)
                    nextRow[j + 1] = WALL_BETWEEN_SETS;
            }

            /* записывает текущую строку в поле лабиринта*/
            for (int k = 0; k < currentRow.length; k++) {
                if (currentRow[k] == WALL_BETWEEN_SETS) {
                    field[2 * i + 1][k + 1] = WALL;
                    field[2 * i + 2][k + 1] = WALL;
                } else {
                    field[2 * i + 1][k + 1] = FREE_PATH;
                    if (currentRow[k] == nextRow[k]) {
                        field[2 * i + 2][k + 1] = FREE_PATH;
                    }
                }
            }
        }
        makeLastRow();
        makeOpenings();
    }

    /**
     * Случайным образом объединяет множества в строке
     */
    private void joinSets() {

        Random rand = new Random();

        for (int i = 1; i < currentRow.length - 1; i += 2) { //проверка только где стены

            /* Проверка на объединение: имеют ли стену между ними, не являются ли частью одного набора
               и если соизволил рандом*/
            if (currentRow[i] == WALL_BETWEEN_SETS && currentRow[i - 1] != currentRow[i + 1]
                    && rand.nextBoolean()) {

                currentRow[i] = 0; //Убираем стену

                /*значение множества, которой будет затерто*/
                int oldSet = Math.max(currentRow[i - 1], currentRow[i + 1]);
                /*значение множества, которое затрет соседнее*/
                dominativeSet = Math.min(currentRow[i - 1], currentRow[i + 1]);

                // Объединяем два набора в один
                for (int j = 0; j < currentRow.length; j++) {
                    if (currentRow[j] == oldSet)
                        currentRow[j] = dominativeSet;
                }
            }
        }
    }


    /* Случайно выбирает вертикальные пути для каждого набора, убедившись,
     * что есть по крайней мере свободный путь в наборе */
    private void makeVerticalPasses() {

        Random rand = new Random();

        /*Начало множества*/
        int beg;
        /*Конец множества*/
        int end;

        /*наличие вертикального прохода вниз*/
        boolean madeVerticalPath;

        int i;
        beg = 0;
        /*Для каждого абора множеств случайным образом создать стены
        * и перенести в сл. строку элементы множеств, оставшихся без стен*/
        do {
            i = beg;

            /* Поиск конца множества*/
            while (i < currentRow.length - 1 && currentRow[i] == currentRow[i + 2]) {
                i += 2;
            }
            end = i;

            //Наличие петли
            madeVerticalPath = false;
            do {
                for (int j = beg; j <= end; j += 2) {
                    if (rand.nextBoolean()) {
                        nextRow[j] = currentRow[j];
                        madeVerticalPath = true;
                    }
                }
            } while (!madeVerticalPath);

            /*устанавливаем в начало сл. набора*/
            beg = end + 2;

        } while (end != currentRow.length - 1);
    }

    /**
     * Генерирует последнюю строку лабиринта
     */
    /*Последняя строка отличается от обычных тем, что
        1) каждая ячейка имеет границу снизу
        2) каждая ячейка должна принадлежать одному множеству.*/
    private void makeLastRow() {

        /* Получаем текущую строки */
        for (int i = 0; i < currentRow.length; i++)
            currentRow[i] = nextRow[i];

        for (int i = 1; i < currentRow.length - 1; i += 2) {
            if (currentRow[i] == WALL_BETWEEN_SETS && currentRow[i - 1] != currentRow[i + 1]) {
                currentRow[i] = 0;

                int oldSet = Math.max(currentRow[i - 1], currentRow[i + 1]);
                dominativeSet2 = Math.min(currentRow[i - 1], currentRow[i + 1]);

                /*Объединяем два набора в один*/
                for (int j = 0; j < currentRow.length; j++) {
                    if (currentRow[j] == oldSet)
                        currentRow[j] = dominativeSet2;
                }
            }
        }

        /*Добавление последней строки*/
        for (int k = 0; k < currentRow.length; k++) {
            if (currentRow[k] == WALL_BETWEEN_SETS)
                field[rows - 2][k + 1] = WALL;
            else
                field[rows - 2][k + 1] = FREE_PATH;
        }
    }

    /**
     * Случайным образом выбирает вход и выход для лабиринта
     */
    public void makeOpenings() {

        Random rand = new Random();
        Random rand2 = new Random();

        //случайное место для входа и выхода
        int entranceRow = rand.nextInt(currRow - 1) * 2 + 1;
        int exitRow = rand2.nextInt(currRow - 1) * 2 + 1;

        field[entranceRow][0] = FREE_PATH;
        field[exitRow][cols - 1] = FREE_PATH;
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}
