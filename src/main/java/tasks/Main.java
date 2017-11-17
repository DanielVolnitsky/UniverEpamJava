package tasks;

import tasks.helpers.ArrayHelper;
import tasks.task3_07_11_2017.entities.Polygon;
import tasks.task3_07_11_2017.entities.Triangle;
import tasks.task3_07_11_2017.entities.additional.GeometricalObjectSelector;
import tasks.task3_07_11_2017.entities.additional.GeometricalObjectsFactory;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        GeometricalObject[] arr = new GeometricalObject[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = GeometricalObjectsFactory.getRandomGeometricalObject();
        }
        ArrayHelper.printArray(arr);

        System.out.println();

        GeometricalObjectSelector.sortByColorfulUncolorful(arr);
        ArrayHelper.printArray(arr);

        System.out.println("\nColored count: " + GeometricalObjectSelector.getColoredCount(arr));
        System.out.println("Uncolored count: " + GeometricalObjectSelector.getNotColoredCount(arr));
        System.out.println("Polygons count: " + GeometricalObjectSelector.getPolygonsCount(arr));
        System.out.println("Triangles count: " + GeometricalObjectSelector.getTrianglesCount(arr));
        System.out.println("Lines count: " + GeometricalObjectSelector.getLinesCount(arr));
        System.out.println("Points count: " + GeometricalObjectSelector.getPointsCount(arr));

        System.out.println();

        for (GeometricalObject obj : arr) {
            if (obj instanceof Triangle) {
                Triangle tr = (Triangle) obj;
                System.out.println(tr + "\nПериметр: " + tr.getPerimeter() + "\nПлощадь: " + tr.getArea());
            }
        }
    }
}
