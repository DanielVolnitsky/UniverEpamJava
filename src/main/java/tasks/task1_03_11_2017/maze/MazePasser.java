package tasks.task1_03_11_2017.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Перечисление возможных направлений из некоторой точки лабиринта
 */
enum PossibleDirection {
    DEADLOCK, UP, RIGHT, DOWN, LEFT
}

/**
 * Класс предназначен для нахождения пути в лабиринте
 *
 * @see EllersMazeBuilder
 */
public class MazePasser {
    static final String FREE_PATH = "  ";
    static final String VISITED = "- ";
    static final String FINAL_PATH_PART = "+ ";

    /*стек для отслеживания местоположения*/
    private Stack<Integer[]> path;

    /*Список точек найденного пути*/
    private ArrayList<Integer[]> finalPath;

    private String[][] maze;
    private int rows, cols;

    public MazePasser(String[][] incomingMaze) {
        initializeMaze(incomingMaze);
        path = new Stack<Integer[]>();
        finalPath = new ArrayList<Integer[]>();
    }

    /**
     * Инициализирует лабиринт
     *
     * @param incomingMaze - входящее значение лабиринта, по которому будет проход
     */
    private void initializeMaze(String[][] incomingMaze) {
        this.maze = new String[incomingMaze.length][incomingMaze[1].length];

        /*заполнение содержимое входного массива в массив прохождения лабиринта*/
        for (int i = 0; i < incomingMaze.length; i++)
            for (int j = 0; j < incomingMaze[i].length; j++)
                this.maze[i][j] = incomingMaze[i][j];

        rows = incomingMaze.length;
        cols = incomingMaze[0].length;
    }

    public void solveMaze() {
        PossibleDirection[] possibleWays;

        findEntrance();

        /*Пока справа от текущего местоположения не окажется выход*/
        while (!isNearExit()) {

            /*получаем возможные направления из точки*/
            possibleWays = getPossibleWays();

            switch (possibleWays[0]) {
                case DEADLOCK:
                    backTrack();
                    break;
                case UP:
                    solveUp();
                    break;
                case RIGHT:
                    solveRight();
                    break;
                case DOWN:
                    solveDown();
                    break;
                case LEFT:
                    solveLeft();
                    break;
            }
        }

        goToExit();
        printPath();
    }

    /**
     * Находит входную точку лабиринта на левой стене
     */
    private void findEntrance() {
        Integer[] entrance = new Integer[2];

        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == FREE_PATH) {
                entrance[0] = i;
                entrance[1] = 0;

                /*Раз мы начинаем с этой точки, устанавливаем ее посещенной*/
                maze[entrance[0]][entrance[1]] = VISITED;
                path.push(entrance);
            }
        }
    }


    private PossibleDirection[] getPossibleWays() {
        PossibleDirection[] ways = new PossibleDirection[4];
        int place = 0;

        PossibleDirection canGoUp = isPossibleToGoUp();
        PossibleDirection canGoRight = isPossibleToGoRight();
        PossibleDirection canGoDown = isPossibleToGoDown();
        PossibleDirection canGoLeft = isPossibleToGoLeft();

        if (canGoUp != PossibleDirection.DEADLOCK)
            ways[place++] = canGoUp;

        if (canGoRight != PossibleDirection.DEADLOCK)
            ways[place++] = canGoRight;

        if (canGoDown != PossibleDirection.DEADLOCK)
            ways[place++] = canGoDown;

        if (canGoLeft != PossibleDirection.DEADLOCK)
            ways[place++] = canGoLeft;

        /*Если ни одного направления не найдено, возвращаем массив тупиков*/
        if (place == 0) {
            for (int i = 0; i < ways.length; i++)
                ways[i] = PossibleDirection.DEADLOCK;

            return ways;
        }
        /*иначе убрать из массива null и вернуть его*/
        else {
            PossibleDirection[] possibleWays = new PossibleDirection[place];
            System.arraycopy(ways, 0, possibleWays, 0, place);

            return possibleWays;
        }
    }

    private PossibleDirection isPossibleToGoUp() {
        Integer[] currentCell = path.peek();

        int nRow = currentCell[0] - 1;
        int nCol = currentCell[1];

        if (nRow > 0)
            if (maze[nRow][nCol] == FREE_PATH)
                return PossibleDirection.UP;

        return PossibleDirection.DEADLOCK;
    }

    private PossibleDirection isPossibleToGoRight() {
        Integer[] currentCell = path.peek();

        int nRow = currentCell[0];
        int nCol = currentCell[1] + 1;

        if (nCol < cols)
            if (maze[nRow][nCol] == FREE_PATH)
                return PossibleDirection.RIGHT;

        return PossibleDirection.DEADLOCK;
    }

    private PossibleDirection isPossibleToGoDown() {
        Integer[] currentCell = path.peek();

        int nRow = currentCell[0] + 1;
        int nCol = currentCell[1];

        if (nRow < rows)
            if (maze[nRow][nCol] == FREE_PATH)
                return PossibleDirection.DOWN;

        return PossibleDirection.DEADLOCK;
    }

    private PossibleDirection isPossibleToGoLeft() {
        Integer[] currentCell = path.peek();

        int nRow = currentCell[0];
        int nCol = currentCell[1] - 1;

        if (nCol > 0)
            if (maze[nRow][nCol] == FREE_PATH)
                return PossibleDirection.LEFT;

        return PossibleDirection.DEADLOCK;
    }

    private void solveUp() {
        Integer[] current = path.peek();
        Integer[] temp = new Integer[2];

        int nRow = current[0] - 1;
        int nCol = current[1];


        maze[nRow][nCol] = VISITED;

        temp[0] = nRow;
        temp[1] = nCol;

        path.push(temp);
    }

    private void solveRight() {
        Integer[] current = path.peek();
        Integer[] temp = new Integer[2];

        int nRow = current[0];
        int nCol = current[1] + 1;
        maze[nRow][nCol] = VISITED;

        temp[0] = nRow;
        temp[1] = nCol;

        path.push(temp);

    }

    private void solveDown() {
        Integer[] temp = new Integer[2];
        Integer[] current = path.peek();

        int nRow = current[0] + 1;
        int nCol = current[1];
        maze[nRow][nCol] = VISITED;

        temp[0] = nRow;
        temp[1] = nCol;

        path.push(temp);
    }

    private void solveLeft() {
        Integer[] temp = new Integer[2];
        Integer[] current = path.peek();

        int nRow = current[0];
        int nCol = current[1] - 1;
        maze[nRow][nCol] = VISITED;

        temp[0] = nRow;
        temp[1] = nCol;

        path.push(temp);
    }

    /* Проверяет, есть ли справа от текущего местоположения выход*/
    private boolean isNearExit() {
        Integer[] current = path.peek();

        if (current[1] == maze[0].length - 2)
            if (maze[current[0]][current[1] + 1] == VISITED)
                return true;

        return false;
    }

    /**
     * Осуществляет переход на клетку выхода
     */
    private void goToExit() {
        Integer[] temp = new Integer[2];
        Integer[] current = path.peek();

        temp[0] = current[0];
        temp[1] = current[1] + 1;

        maze[temp[0]][temp[1]] = VISITED;

        path.push(temp);
    }

    /**
     * Возвращаемся на точку назад
     */
    private void backTrack() {
        path.pop();
    }

    void printPath() {
        Integer[] placement;

        while (!path.empty()) {
            placement = path.pop();
            maze[placement[0]][placement[1]] = FINAL_PATH_PART;

            finalPath.add(placement);
        }
        cleanMazeFromVisitedCells();
    }

    /**
     * Стирает обозначения пройденных точек
     */
    private void cleanMazeFromVisitedCells() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (maze[i][j] == VISITED)
                    maze[i][j] = FREE_PATH;
    }

    public void printSolution() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public void printFinalPass() {
        Collections.reverse(finalPath);
        for (Integer[] point : finalPath)
            System.out.print("[" + point[0] + "," + point[1] + "]");

        Collections.reverse(finalPath);
    }
}