package tasks.task3_07_11_2017.entities.additional;

import tasks.helpers.ArrayHelper;
import tasks.task3_07_11_2017.entities.Line;
import tasks.task3_07_11_2017.entities.Point;
import tasks.task3_07_11_2017.entities.Polygon;
import tasks.task3_07_11_2017.entities.Triangle;
import tasks.task3_07_11_2017.interfaces.Colorful;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class Sorter {

    public static void sortByColorfulUncolorful(GeometricalObject[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] instanceof Colorful){
                for (int j = arr.length - 1; j > i; j--) {
                    if (!(arr[j] instanceof Colorful)) {
                        ArrayHelper.swapTwoElements(arr, i, j);
                        break;
                    }
                }
            }
        }
    }

    public static int getColorfulCount(GeometricalObject[] arr){
        int counter = 0;
        for (int i = 0; i < arr.length; i++)
            if(arr[i] instanceof Colorful)
                counter++;

        return counter;
    }

    public static int getNotColorfulCount(GeometricalObject[] arr){
        int counter = 0;
        for (GeometricalObject gobj : arr)
            if(!(gobj instanceof Colorful))
                counter++;

        return counter;
    }

    public static int getPolygonsCount(GeometricalObject[] arr){
        int counter = 0;
        for (GeometricalObject gobj : arr)
            if(gobj instanceof Polygon)
                counter++;

        return counter;
    }

    public static int getTrianglesCount(GeometricalObject[] arr){
        int counter = 0;
        for (GeometricalObject gobj : arr)
            if(gobj instanceof Triangle)
                counter++;

        return counter;
    }

    public static int getLinesCount(GeometricalObject[] arr){
        int counter = 0;
        for (GeometricalObject gobj : arr)
            if(gobj instanceof Line)
                counter++;

        return counter;
    }

    public static int getPointsCount(GeometricalObject[] arr){
        int counter = 0;
        for (GeometricalObject gobj : arr)
            if(gobj instanceof Point)
                counter++;

        return counter;
    }
}
