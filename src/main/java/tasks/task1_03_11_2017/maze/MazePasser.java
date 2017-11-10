package tasks.task1_03_11_2017.maze;

import java.util.ArrayDeque;

/**Поиск выхода из лабиринта*/
public class MazePasser {

    /*массив прохождения лабиринта*/
    String[][] maze;
    //Integer [][] finalPath;
    ArrayDeque<Integer[]> path;

    int rows, cols;

    /**@param feild - поле лабиринта*/
    public  MazePasser(String[][] feild) {
        //инициализирует массив прохождение лабиринта и длины введенного массива
        maze = new String[feild.length][feild[1].length];

        //копирует содержимое входного массива в массив прохождения лабиринта
        for (int i = 0; i < feild.length; i++) {
            for (int j = 0; j < feild[i].length; j++) {
                maze[i][j] = feild[i][j];
            }
        }

        rows = feild.length;
        cols = feild[0].length;

        path = new ArrayDeque<Integer[]>(rows * cols);
    }

    public String[][] getMaze() {
        return maze;
    }
    public String[][] getSolution() {
        return maze;
    }

    public void solveMaze() {
        int[] possibleWays; //хранит возможные ходы для каждого положения

        setInitialLocation(); //поиск начала лабиринта
        while (!nearExit()) {
            possibleWays = getPossibleWays(); /*получение возможных направлений*/

            if (possibleWays[0] == 0) {  //если тупик
                stepBack();
            }
            else {
                if (possibleWays[0] == 1) {
                    solveUp();
                } else if (possibleWays[0] == 2) {
                    solveRight();
                } else if (possibleWays[0] == 3) {
                    solveDown();
                } else if (possibleWays[0] == 4) {
                    solveLeft();
                }
            }
        }

        goToExit();
        solvePath();
    }

    public void setInitialLocation() {

        Integer[] temp = new Integer[2]; //доступ

        //перебор и поиск входа
        for (int i = 0; i < maze.length; i++) {
            //если он находит пустое место, это вход
            if (maze[i][0] == "  ") {

                //набор текущего положения
                temp[0] = i;
                temp[1] = 0;

                //устанавливаем указатель -
                maze[temp[0]][temp[1]] = "- ";
                path.addFirst(temp);
            }
        }
    }

    /**Возвращает возможные направления из данной точки*/
    public int[] getPossibleWays() {
        int[] ways = new int[4];
        int place = 0;

        if (canSolveUp() != 0) {
            ways[place++] = canSolveUp();
        }
        if (canSolveRight() != 0) {
            ways[place++] = canSolveRight();
        }
        if (canSolveDown() != 0) {
            ways[place++] = canSolveDown();
        }
        if (canSolveLeft() != 0) {
            ways[place++] = canSolveLeft();
        }

        //возвращаем ноль, если нет направления
        if (place == 0) {
            for (int i = 0; i < 4; i++)
                ways[i] = 0;

            return ways;
        }
        else { //иначе уменьшить массив и вернуть его
            int[] possibleWays = new int[place];
            for (int i = 0; i < place; i++) {
                possibleWays[i] = ways[i];
            }
            return possibleWays;
        }
    }

    public void solveUp() {
        Integer[] current = path.peek(); //текущее положение
        Integer[] next = new Integer[2]; //получение следующего положения

        int nRow = current[0] - 1;  //переход вверх
        int nCol = current[1];

        maze[nRow][nCol] = "  ";

        next[0] = nRow;
        next[1] = nCol;

        path.addFirst(next);
    }

    public void solveRight() {
        Integer[] current = path.peek(); //получаем положение
        Integer[] temp = new Integer[2]; //добавляем следующее

        int nRow = current[0];   //переход дальше
        int nCol = current[1] + 1;
        maze[nRow][nCol] = "- ";  //устанавливаем указатель

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp);

    }

    public void solveDown() {
        Integer[] temp = new Integer[2]; //текущее положение
        Integer[] current = path.peek(); //добавление следующего положения

        int nRow = current[0] + 1;   //переход
        int nCol = current[1];
        maze[nRow][nCol] = "- ";  //помещаем в стек, устанавливаем указатель -

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp); //pushes the nextRow location to the stack

    }

    public void solveLeft() {
        Integer[] temp = new Integer[2]; //текущее положение
        Integer[] current = path.peek(); //добаление следующего положения

        int nRow = current[0];   //переход
        int nCol = current[1] - 1;
        maze[nRow][nCol] = "- ";  //помещаем в стек, устанавливаем указатель -

        temp[0] = nRow;
        temp[1] = nCol;

        path.addFirst(temp); //Добавляем в стек

    }

    public int canSolveUp() {
        Integer[] temp = path.peekFirst(); //Массив для получения доступа

        int nRow = temp[0] - 1; //устанавливаем следующее местоположение
        int nCol = temp[1];

        //если рядом есть правильный путь, вернуть 1
        if (nRow > 0) {
            if (maze[nRow][nCol] == "  ") {
                return 1;
            }
        }
        return 0;
    }

    public int canSolveRight() {
        Integer[] temp = new Integer[2]; //получаем доступ
        temp = path.peek();

        int nRow = temp[0];   //переходим дальшн
        int nCol = temp[1] + 1;

        //если рядом есть правильный путь, вернуть 2
        if (nCol < cols) {
            if (maze[nRow][nCol] == "  ") {
                return 2;
            }
        }

        return 0; //иначе 0

    }

    public int canSolveDown() {
        Integer[] temp = new Integer[2]; //проверям доступ
        temp = path.peek();

        int nRow = temp[0] + 1;  //переход дальше
        int nCol = temp[1];

        //если рядом есть правильный путь, вернуть 3
        if (nRow < rows) {
            if (maze[nRow][nCol] == "  ") {
                return 3;
            }
        }

        return 0;  //иначе 0

    }

    public int canSolveLeft() {
        Integer[] temp = new Integer[2]; //проверяем доступ
        temp = path.peek();

        int nRow = temp[0];   //переходим дальше
        int nCol = temp[1] - 1;


        //если рядом есть правильный путь, вернуть 4
        if (nCol > 0) {
            if (maze[nRow][nCol] == "  ") {
                return 4;
            }
        }

        return 0; //иначе 0

    }

    public boolean nearExit() {
        Integer[] temp = path.peek();
        if (temp[1] == maze[0].length - 2) {
            if (maze[temp[0]][temp[1] + 1] == "  ") {
                return true;
            }
        }

        return false;
    }

    public void goToExit() {
        Integer[] temp = new Integer[2]; //доступ к стеку
        Integer[] current = path.peek(); //текущее положение

        temp[0] = current[0];   //Выход справа
        temp[1] = current[1] + 1;

        maze[temp[0]][temp[1]] = "- "; //устанавливаем указатель  -

        path.push(temp); //добавляем в стек

    }

    public void stepBack() {
        path.removeFirst();
    }


    /**Помечает путь*/
    public void solvePath() {
        Integer[] temp; //доступ к стеку

        //finalPath = new Integer[][];
        int k = 0;

        while (path.peek() != null) {
            temp = path.pop(); //текущее положение
            //finalPath[k++] = temp;
            maze[temp[0]][temp[1]] = "+ "; //устанавливаем указатель +
        }


        /*Очистка от знаков тупика*/
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == "- ")
                    maze[i][j] = "  ";
            }
        }
    }

    public void printSolution() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
