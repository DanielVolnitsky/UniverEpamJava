package tasks.task3_07_11_2017.entities;

import tasks.helpers.GeometricHelper;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

import java.util.Arrays;

/**
 * Класс представляет многоугольник на плоскости
 *
 * @see Point
 * @see GeometricHelper#rotate(Point, Point, Point)
 */
public class Polygon implements GeometricalObject {

    private Point[] points;

    protected Polygon() {

    }

    public Polygon(Point[] points) throws IllegalArgumentException {
        setPoints(points);
    }

    public Point[] getPoints() {
        return this.points;
    }

    /**@param points - входящий набор точек*/
    public void setPoints(Point[] points) throws  IllegalArgumentException{
        if (points != null && points.length > 3) {
            this.points = points;
            sortPointsByLeftism();
        } else {
            throw new IllegalArgumentException("To build polygon more that 3 points needed.");
        }
    }

    /**
     * Сортирует точки в порядке их “левизны” относительно начальной точки (самой левой),
     * с помощью векторного произведения векторов.
     */
    private void sortPointsByLeftism() {

        /*ищем индекс самой левой точки*/
        int leftmost = 0;
        for (int i = 1; i < points.length; i++)
            if (points[i].getX() < points[leftmost].getX())
                leftmost = i;

        /*перемещаем ее в начало массива*/
        Point buffer = points[leftmost];
        points[leftmost] = points[0];
        points[0] = buffer;

        /**Сортировка вставками всех точек (кроме первой), по степени их левизны относительно стартовой точки*/
        Point left = points[0];
        int n = points.length;
        int i, j;
        for (i = 1; i < n; i++) {
            Point temp = points[i];
            j = i;
            /*B < C, если точка С находится по левую сторону от вектора AB, где A - самая левая точка.*/
            while (j > 1 && GeometricHelper.rotate(left, temp, points[j - 1]) > 0) {
                points[j] = points[j - 1];
                j--;
            }
            points[j] = temp;
        }
    }

    @Override
    public String toString() {
        return "polygon {" +
                "points: " + Arrays.toString(points) +
                '}';
    }
}
