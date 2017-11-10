package tasks.task1_03_11_2017.maze;


import java.util.Random;

/*Алгоритм Эллера позволяет создавать лабиринты, имеющие только один путь между двумя точками.
        Сам по себе алгоритм очень быстр и использует память эффективнее, чем другие популярные
        алгоритмы (такие как Prim и Kruskal), требуя памяти пропорционально числу строк.
        Это позволяет создавать лабиринты большого размера при ограниченных размерах памяти.*/

public class EllersMazeBuilder {

    /**Стена между представителями множеств*/
    static final int SET_WALL = -1;
    static final String MAZE_WALL = "* ";
    static final String MAZE_PATH = "  ";
    static final int UNDETERMINED = -2;

    int rows, cols;
    int currRowNumber, currColNumber;

    String[][] matrix;

    int[] currRow;
    int[] nextRow;

    //количество моножеств
    int setsCount;

    private Random rand;

    /*множество, покрывающее другое*/
    private int coveringSet;
    private int coveringSet2;

    /**
     * Инициализирует матрицу-поле, заполняет стенами, находит количество множеств
     */
    public EllersMazeBuilder(int rowsCount, int colsCount) {
        currRowNumber = rowsCount; //5
        currColNumber = colsCount; //5

        rows = currRowNumber * 2 + 1; //11
        cols = currColNumber * 2 + 1; //11

        matrix = new String[rows][cols];

        currRow = new int[currColNumber * 2 - 1]; //int[9]
        nextRow = new int[currColNumber * 2 - 1]; //int[9]

        fillMazeByWalls(matrix);
        setNextRowUndefined();
        initializeFirstRow();
    }

    public String[][] getMaze() {
        return matrix;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    /**Метод постройки лабиринта*/
    public void buildMaze() {

        setRand(new Random());

        for (int strIndex = 0; strIndex < currRowNumber - 1; strIndex++) { //для всех строк кроме последней

            if (strIndex != 0) { //первая строка уже сгенерирована
                /*получим текущую строку из последней итерации*/
                for (int i = 0; i < currRow.length; i++) {
                    currRow[i] = nextRow[i];
                    nextRow[i] = UNDETERMINED;
                }
            }

            mergeSets();
            generateBottomBounds();
            fillNextRowEmptyFields();
            writeCurrentRowToMatrix(strIndex);
        }
        makeLastRow();
        makeOpenings();
    }

    private void mergeSets() {
        Random rand = new Random();

        /* Случайные наборы */
        for (int i = 1; i < currRow.length - 1; i += 2) { //проверка только где стены

            /* Проверка на объединение: Имеют ли стену между ними, не являются ли частью
             одного набора и если зарандомится true - Получаем случайный набор, при объединении*/
            if (currRow[i] == SET_WALL && currRow[i - 1] != currRow[i + 1] && rand.nextBoolean()) {

                /*убираем стену*/
                currRow[i] = 0;

                /*значение множества, которое будет покрыто другим*/
                int overlyingSet = Math.max(currRow[i - 1], currRow[i + 1]);
                 /*устанавливаем значение множества, которое его покроет*/
                coveringSet = Math.min(currRow[i - 1], currRow[i + 1]);

                /*Объединяем два множества в одно*/
                for (int j = 0; j < currRow.length; j++) {
                    if (currRow[j] == overlyingSet)
                        currRow[j] = coveringSet;
                }
            }
        }
    }


    /* Случайно создаем нижние границы, убедившись,
     * что есть по крайней мере 1 вертикальный путь в наборе*/
    private void generateBottomBounds() {
        Random rand = new Random();

        int begining;     //Начало набора(Включительно)
        int end;          //Конец набор(Включительно)

        boolean madeVertical;  //Создание вертикального прохода

        int i;
        begining = 0;
        do {
            /*Поиск конца множества*/
            i = begining;
            while (i < currRow.length - 1 && currRow[i] == currRow[i + 2]) {
                i += 2;
            }
            end = i;

            //Наличие петли
            madeVertical = false;
            do {
                for (int j = begining; j <= end; j += 2) {
                    if (rand.nextBoolean()) {
                        /*В следующую строку идут ячейки множества, не имеющие нижнюю границу*/
                        nextRow[j] = currRow[j];
                        madeVertical = true;
                    }
                }
            } while (!madeVertical);

            /*переход к следующему набору в строке*/
            begining = end + 2;

        } while (end != currRow.length - 1);
    }

    /* заполним оставшуюся часть следующей строки*/
    private void fillNextRowEmptyFields(){
        for (int j = 0; j < currRow.length; j += 2) {
            if (nextRow[j] == UNDETERMINED)
                nextRow[j] = ++setsCount;

            if (j != currRow.length - 1)
                nextRow[j + 1] = SET_WALL;
        }
    }

    private void writeCurrentRowToMatrix(int strIndex){
        /* запишем текущую строку в поле */
        for (int k = 0; k < currRow.length; k++) {

            if (currRow[k] == SET_WALL) {
                matrix[2 * strIndex + 1][k + 1] = MAZE_WALL;
                matrix[2 * strIndex + 2][k + 1] = MAZE_WALL;
            } else {
                matrix[2 * strIndex + 1][k + 1] = MAZE_PATH;

                if (currRow[k] == nextRow[k]) {
                    matrix[2 * strIndex + 2][k + 1] = MAZE_PATH;
                }
            }
        }
    }

    /*Каждая ячейка последней строки имеет границу снизу и принадлежит
        одному (единственному) множеству*/
    private void makeLastRow() {

        /* Получение текущей строки */
        for (int i = 0; i < currRow.length; i++) {
            currRow[i] = nextRow[i];
        }

        for (int i = 1; i < currRow.length - 1; i += 2) {

            if (currRow[i] == SET_WALL && currRow[i - 1] != currRow[i + 1]) {
                currRow[i] = 0;

                int old = Math.max(currRow[i - 1], currRow[i + 1]);
                coveringSet2 = Math.min(currRow[i - 1], currRow[i + 1]);

                // Объединяем два набора в один
                for (int j = 0; j < currRow.length; j++) {
                    if (currRow[j] == old)
                        currRow[j] = coveringSet2;
                }
            }
        }

        /* Добавление последней строки */
        for (int k = 0; k < currRow.length; k++) {
            if (currRow[k] == SET_WALL) {
                matrix[rows - 2][k + 1] = MAZE_WALL;
            } else {
                matrix[rows - 2][k + 1] = MAZE_PATH;
            }
        }
    }

    /*Определить случайное место входа и выхода*/
    public void makeOpenings() {

        Random rand1 = new Random();
        Random rand2 = new Random();

        //случайное место для входа и выхода
        int entranceRow = rand1.nextInt(currRowNumber - 1) * 2 + 1;
        int exitRow = rand2.nextInt(currRowNumber - 1) * 2 + 1;

        //очистить ячейки входа и выхода
        matrix[entranceRow][0] = MAZE_PATH;
        matrix[exitRow][cols - 1] = MAZE_PATH;
    }

    /* заполняет все поле знаком стены */
    private void fillMazeByWalls(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = MAZE_WALL;
            }
        }
    }

    /**
     * устанавливаем следующую строку неопределенной
     */
    private void setNextRowUndefined() {
        for (int i = 0; i < nextRow.length; i++)
            nextRow[i] = UNDETERMINED;
    }

    /* Инициализация первой строки */
    private void initializeFirstRow() {
        for (int i = 0; i < currRow.length; i += 2) {
            currRow[i] = i / 2 + 1;
            if (i != currRow.length - 1)
                currRow[i + 1] = SET_WALL;
        }
        setsCount = currRow[currRow.length - 1];
    }

    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void printArray(char[][] matr) {
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[i].length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
