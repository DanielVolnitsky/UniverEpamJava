package tasks.helpers;

import tasks.task3_07_11_2017.entities.Line;
import tasks.task3_07_11_2017.entities.Point;
import tasks.task3_07_11_2017.entities.Triangle;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static tasks.helpers.ArithmeticHelper.getRoundedDouble;

public class GeometryHelper {

    /**@return периметр треугольника*/
    public static double getTrianglePerimeter(Triangle tr){

        /*Находим координаты векторов*/
        int x1 = tr.getApexB().getX() - tr.getApexA().getX();
        int y1 = tr.getApexB().getY() - tr.getApexA().getY();

        int x2 = tr.getApexC().getX() - tr.getApexB().getX();
        int y2 = tr.getApexC().getY() - tr.getApexB().getY();

        int x3 = tr.getApexC().getX() - tr.getApexA().getX();
        int y3 = tr.getApexC().getY() - tr.getApexA().getY();

        /*Находим модули векторов*/
        double abMod = getRoundedDouble(sqrt(pow(x1, 2) + pow(y1, 2)), 3);
        double bcMod = getRoundedDouble(sqrt(pow(x2, 2) + pow(y2, 2)), 3);
        double acMod = getRoundedDouble(sqrt(pow(x3, 2) + pow(y3, 2)), 3);

        return abMod + bcMod + acMod;
    }

    /**@return площадь треугольника*/
    public static double getTriangleArea(Triangle tr){

        /*Находим координаты векторов*/
        int x1 = tr.getApexB().getX() - tr.getApexA().getX();
        int y1 = tr.getApexB().getY() - tr.getApexA().getY();

        int x2 = tr.getApexC().getX() - tr.getApexB().getX();
        int y2 = tr.getApexC().getY() - tr.getApexB().getY();

        int x3 = tr.getApexC().getX() - tr.getApexA().getX();
        int y3 = tr.getApexC().getY() - tr.getApexA().getY();

        return 0.5 * Math.abs((x1-x3)*(y2-y3)-(x2-x3)*(y1-y3));
    }

    /**
     * Проверяет, лежат ли 3 точки на одной прямой
     *
     * @param x1 - координата x 1 точки
     * @param y2 - координата y 1 точки
     */
    private static boolean isPointsOnSameLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1);
    }

    /**
     * Проверяет, лежат ли 3 точки на одной прямой
     */
    public static boolean isPointsOnSameLine(Point p1, Point p2, Point p3) {
        int x1 = p1.getX();
        int y1 = p1.getY();

        int x2 = p2.getX();
        int y2 = p2.getY();

        int x3 = p3.getX();
        int y3 = p3.getY();

        return isPointsOnSameLine(x1, y1, x2, y2, x3, y3);
    }

    public static boolean equalPoints(Point p1, Point p2, Point p3) {
        return p1.equals(p2) || p2.equals(p3) || p1.equals(p3);
    }

    public static boolean equalPoints(Point p1, Point p2) {
        if(p1 == null || p2 == null)
            return false;
        else
            return p1.equals(p2);
    }
}
