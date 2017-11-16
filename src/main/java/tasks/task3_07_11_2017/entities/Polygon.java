package tasks.task3_07_11_2017.entities;

import tasks.task3_07_11_2017.interfaces.GeometricalObject;

import java.util.Arrays;

public class Polygon implements GeometricalObject {

    //точка центра
    Point center;

    //массив точек
    Point[] points;

    //кол-во граней
    private int facetCount;

    //радиус
    private int radius = 50;

    protected Polygon(){

    }

    public Polygon(int facetCount, int radius, Point center) {
        this.center = center;
        this.facetCount = facetCount;
        this.radius = radius;
        points = new Point[facetCount + 1];

        generatePoints();
    }

    private void generatePoints() {
        double z = 0;
        int i = 0;
        double angle = 360.0 / facetCount;

        //цикл создающий точки
        while (i < facetCount + 1) {
            int newX = center.getX() + (int) (Math.round(Math.cos(z / 180 * Math.PI) * radius));
            int newY = center.getY() - (int) (Math.round(Math.sin(z / 180 * Math.PI) * radius));
            points[i] = new Point(newX, newY);
            z = z + angle;
            i++;
        }
    }

    @Override
    public String toString() {
        return "polygon: {" +
                "radius: " + radius +
                ", facetCount: " + facetCount +
                ", points: " + Arrays.toString(points) + "}";
    }
}
