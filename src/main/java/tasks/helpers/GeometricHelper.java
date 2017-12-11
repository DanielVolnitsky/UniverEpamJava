package tasks.helpers;

import tasks.task03_07_11_2017.entities.Point;
import tasks.task03_07_11_2017.entities.Triangle;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static tasks.helpers.ArithmeticHelper.getRoundedDouble;

public class GeometricHelper {

    /**
     * @return периметр треугольника
     */
    public static double getTrianglePerimeter(Triangle tr) throws NullPointerException {
        try {
            int roundedValue = 3;
            /*Находим координаты векторов*/
            int x1 = tr.getApexB().getX() - tr.getApexA().getX();
            int y1 = tr.getApexB().getY() - tr.getApexA().getY();

            int x2 = tr.getApexC().getX() - tr.getApexB().getX();
            int y2 = tr.getApexC().getY() - tr.getApexB().getY();

            int x3 = tr.getApexC().getX() - tr.getApexA().getX();
            int y3 = tr.getApexC().getY() - tr.getApexA().getY();

            /*Находим модули векторов*/
            double abMod = getRoundedDouble(sqrt(pow(x1, 2) + pow(y1, 2)), roundedValue);
            double bcMod = getRoundedDouble(sqrt(pow(x2, 2) + pow(y2, 2)), roundedValue);
            double acMod = getRoundedDouble(sqrt(pow(x3, 2) + pow(y3, 2)), roundedValue);

            return getRoundedDouble(abMod + bcMod + acMod, 3);
        } catch (NullPointerException e) {
            throw new NullPointerException("передаваемый треугольник и его вершины не должны быть null.");
        }
    }

    /**
     * @return площадь треугольника
     */
    public static double getTriangleArea(Triangle tr) {
        try {
             /*Находим координаты векторов*/
            int x1 = tr.getApexB().getX() - tr.getApexA().getX();
            int y1 = tr.getApexB().getY() - tr.getApexA().getY();

            int x2 = tr.getApexC().getX() - tr.getApexB().getX();
            int y2 = tr.getApexC().getY() - tr.getApexB().getY();

            int x3 = tr.getApexC().getX() - tr.getApexA().getX();
            int y3 = tr.getApexC().getY() - tr.getApexA().getY();

            return 0.5 * Math.abs((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3));
        } catch (NullPointerException e) {
            throw new NullPointerException("передаваемый треугольник и его вершины не должны быть null.");
        }

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
    public static boolean isPointsOnSameLine(Point p1, Point p2, Point p3) throws NullPointerException {
        try {
            int x1 = p1.getX();
            int y1 = p1.getY();

            int x2 = p2.getX();
            int y2 = p2.getY();

            int x3 = p3.getX();
            int y3 = p3.getY();

            return isPointsOnSameLine(x1, y1, x2, y2, x3, y3);
        } catch (NullPointerException e) {
            throw new NullPointerException("передаваемые точки не должны быть null.");
        }
    }

    public static boolean equalPoints(Point p1, Point p2, Point p3) throws NullPointerException {
        try {
            return p1.equals(p2) || p2.equals(p3) || p1.equals(p3);
        } catch (NullPointerException e) {
            throw new NullPointerException("передаваемые точки не должны быть null.");
        }
    }

    public static boolean equalPoints(Point p1, Point p2) throws NullPointerException {
        try {
            return p1.equals(p2);
        } catch (NullPointerException e) {
            throw new NullPointerException("передаваемые точки не должны быть null.");
        }
    }

    /**
     * определяет, с какой стороны от вектора AB находится точка C
     * if < 0 - справа
     * if > 0 - слева
     * = 0 - лежит на одной линии
     */
    public static int rotate(Point A, Point B, Point C) throws NullPointerException {
        try {
            return (B.getX() - A.getX()) * (C.getY() - B.getY()) - (B.getY() - A.getY()) * (C.getX() - B.getX());
        } catch (NullPointerException e) {
            throw new NullPointerException("передаваемые точки не должны быть null.");
        }
    }
}
