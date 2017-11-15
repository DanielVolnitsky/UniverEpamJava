package tasks;

import tasks.helpers.ArrayHelper;
import tasks.task3_07_11_2017.entities.GeometricalObjectsFactory;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        GeometricalObject[] arr = new GeometricalObject[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = GeometricalObjectsFactory.getRandomGeometricalObject();
        }

        ArrayHelper.printArray(arr);
    }
}
