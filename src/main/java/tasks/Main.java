package tasks;

import tasks.helpers.ArrayHelper;
import tasks.task3_07_11_2017.entities.GeometricalObjectsFactory;
import tasks.task3_07_11_2017.entities.Point;
import tasks.task3_07_11_2017.entities.Polygon;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        Polygon pol = new Polygon(6, 4, new Point(5,4));
        System.out.println(pol);
//        GeometricalObject[] arr = new GeometricalObject[20];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = GeometricalObjectsFactory.getRandomGeometricalObject();
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
