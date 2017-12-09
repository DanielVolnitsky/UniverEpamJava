package tasks.task3_07_11_2017.entities.demonstrators;

import tasks.helpers.Demonstrator;
import tasks.task3_07_11_2017.entities.Line;
import tasks.task3_07_11_2017.entities.Point;
import tasks.task3_07_11_2017.entities.Triangle;
import tasks.task3_07_11_2017.interfaces.GeometricalObject;

import java.io.*;
import java.util.Arrays;

public class SerializingDemonstrator implements Demonstrator {

    @Override
    public void demonstrate() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 5);
        Point p3 = new Point(3, 8);

        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p2, p3);
        Line line3 = new Line(p1, p3);

        Triangle triangle1 = new Triangle(line1, line2, line3);

        GeometricalObject[] arr = {p1, p2, p3, line1, line2, line3, triangle1};
        GeometricalObject[] desArr = new GeometricalObject[arr.length];

        try {
            File file = new File("src\\main\\java\\tasks\\task3_07_11_2017\\additional\\SerializedGeomObjects");
            try (ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(file));
                 ObjectInputStream istream = new ObjectInputStream(new FileInputStream(file))) {

                for (int i = 0; i < arr.length; i++)
                    ostream.writeObject(arr[i]);

                for (int i = 0; i < arr.length; i++) {
                    Object desObj = istream.readObject();
                    if (desObj instanceof Point) {
                        desArr[i] = (Point) desObj;
                    } else if (desObj instanceof Line) {
                        desArr[i] = (Line) desObj;
                    } else if (desObj instanceof Triangle) {
                        desArr[i] = (Triangle) desObj;
                    }
                }

                System.out.println("Initial array:\n" + Arrays.toString(arr));
                System.out.println("Deserialized array:\n" + Arrays.toString(desArr));

                System.out.println("\nCheck reference equality of objects:");
                Point dp1 = (Point) desArr[0];
                Point dp2 = (Point) desArr[1];
                Point dp3 = (Point) desArr[2];

                Line dline1 = (Line) desArr[3];
                Line dline2 = (Line) desArr[4];
                Line dline3 = (Line) desArr[5];

                Triangle dtr1 = (Triangle) desArr[6];

                System.out.println("line1.beg == p1: " + (dline1.getBeg() == dp1));
                System.out.println("line1.end == p2: " + (dline1.getEnd() == dp2));

                System.out.println("line2.beg == p2: " + (dline2.getBeg() == dp2));
                System.out.println("line2.end == p3: " + (dline2.getEnd() == dp3));

                System.out.println("line3.beg == p1: " + (dline3.getBeg() == dp1));
                System.out.println("line3.end == p3: " + (dline3.getEnd() == dp3));

                System.out.println("tr1.sideAB == line1: " + (dtr1.getSideAB() == dline1));
                System.out.println("tr1.sideBC == line2: " + (dtr1.getSideBC() == dline2));
                System.out.println("tr1.sideAC == line3: " + (dtr1.getSideAC() == dline3));
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("failed to serialize objects: " + ex.getMessage());
        }
    }
}
