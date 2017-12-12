package tasks.task03_07_11_2017.entities.additional;

import tasks.task03_07_11_2017.entities.Line;
import tasks.task03_07_11_2017.entities.Point;
import tasks.task03_07_11_2017.entities.Triangle;
import tasks.task03_07_11_2017.interfaces.GeometricalObject;

import java.io.*;

public class SerializationHelper {
    public static void serialize(File file, GeometricalObject[] arr) {
        try {
            try (ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(file))) {
                /*сериализируем все объекты в файл*/
                for (int i = 0; i < arr.length; i++) {
                    ostream.writeObject(arr[i]);
                }
            }
        } catch (IOException ex) {
            System.err.println("failed to serialize objects: " + ex.getMessage());
        }
    }

    public static void deserialize(File file, GeometricalObject[] desArr) {
        try {
            try (ObjectInputStream istream = new ObjectInputStream(new FileInputStream(file))) {
                /*десериализируем*/
                for (int i = 0; i < desArr.length; i++) {
                    Object desObj = istream.readObject();
                    if (desObj instanceof Point) {
                        desArr[i] = (Point) desObj;
                    } else if (desObj instanceof Line) {
                        desArr[i] = (Line) desObj;
                    } else if (desObj instanceof Triangle) {
                        desArr[i] = (Triangle) desObj;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("failed to deserialize objects: " + ex.getMessage());
        }
    }
}
