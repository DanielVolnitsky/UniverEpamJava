package tasks.task11_12_12_2017;

import tasks.task11_12_12_2017.entities.GeometryDBHelper;
import tasks.task11_12_12_2017.entities.Point;

abstract
public class Main {

    public static void main(String args[]) {

        try (GeometryDBHelper geometryDBHelper = new GeometryDBHelper(
                "geometry", "localhost", 3306)) {

            System.out.println("Polygons and their points:");

            /*select example*/
            geometryDBHelper.selectPolygonsWithTheirPoints();
            System.out.println();

            /*insert example*/
            geometryDBHelper.insertPoint(899, 899);
            Point point = geometryDBHelper.selectPointByXY(899, 899);

            /*delete example*/
            geometryDBHelper.deletePoint(point.getId());

            /*update example*/
            int id = 1;
            Point point1 = geometryDBHelper.selectPointById(id);
            geometryDBHelper.changePointParams(point1.getId(), 666, 666);
            geometryDBHelper.changePointParams(point1.getId(), point1.getX(), point1.getY());

            System.out.println("\nAll points:");
            geometryDBHelper.selectAllPoints();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
