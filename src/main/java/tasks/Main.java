package tasks;

import tasks.helpers.ArrayHelper;
import tasks.task3_07_11_2017.entities.Triangle;
import tasks.task3_07_11_2017.entities.additional.GeometricalObjectsFactory;
import tasks.task3_07_11_2017.entities.additional.Sorter;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        GeometricalObject[] arr = new GeometricalObject[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = GeometricalObjectsFactory.getRandomGeometricalObject();
        }
        ArrayHelper.printArray(arr);

        System.out.println();

        Sorter.sortByColorfulUncolorful(arr);
        ArrayHelper.printArray(arr);

        System.out.println("\nColored count: " + Sorter.getColorfulCount(arr));
        System.out.println("Uncolored count: " + Sorter.getNotColorfulCount(arr));
        System.out.println("Polygons count: " + Sorter.getTrianglesCount(arr));
        System.out.println("Triangles count: " + Sorter.getTrianglesCount(arr));
        System.out.println("Lines count: " + Sorter.getLinesCount(arr));
        System.out.println("Points count: " + Sorter.getPointsCount(arr));

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] instanceof Triangle) {
                Triangle tr = (Triangle) arr[i];
                System.out.println(tr + "\nПериметр: " + tr.getPerimeter() + "\nПлощадь: " + tr.getArea());
            }
        }
    }
}
