package tasks.task11_12_12_2017.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.task11_12_12_2017.exceptions.NoPointWithGivenIdException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class GeometryDBHelperTest {

    static GeometryDBHelper geometryDBHelper;
    Point point;
    Point resultPoint;
    Polygon polygon;

    @BeforeAll
    static void initialize() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        geometryDBHelper = new GeometryDBHelper("geometry_test", "localhost", 3306);
    }

    @AfterAll
    static void nullify() throws Exception {
        geometryDBHelper.close();
    }

    @Test
    void insertPoint() {
        try {
            int x = 999;
            int y = 999;

            geometryDBHelper.insertPoint(x, y);

            Point result = geometryDBHelper.selectPointByXY(x, y);
            Point expected = new Point(result.getId(), x, y);
            assertEquals(expected, result);

            geometryDBHelper.deletePoint(result.getId());
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void insertPolygon() {
        try {
            int expected = 1;
            int result = geometryDBHelper.insertPolygon();
            assertEquals(expected, result);
            geometryDBHelper.deletePolygon(2);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void setPointToPolygon() {
        try {
            polygon = geometryDBHelper.getPolygonById(1);
            point = geometryDBHelper.selectPointById(1);

            int expected = 1;
            int result = geometryDBHelper.setPointToPolygon(polygon.getId(), point.getId());
            assertEquals(expected, result);

            geometryDBHelper.removePointFromPolygon(polygon.getId(), point.getId());
        } catch (SQLException | NoPointWithGivenIdException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deletePoint() {
        try {
            int x = 999;
            int y = 999;

            geometryDBHelper.insertPoint(x, y);

            point = geometryDBHelper.selectPointByXY(x, y);
            geometryDBHelper.deletePoint(point.getId());
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void changePointParams() {
        int id = 1;
        int x = 888;
        int y = 888;
        try {
            point = geometryDBHelper.selectPointById(id);
            geometryDBHelper.changePointParams(point.getId(), x, y);

            Point expected = new Point(point.getId(), x, y);
            Point result = geometryDBHelper.selectPointById(id);

            assertEquals(expected, result);

            geometryDBHelper.changePointParams(point.getId(), point.getX(), point.getY());
        } catch (NoPointWithGivenIdException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void selectPointById() {
        int id = 1;
        try {
            resultPoint = geometryDBHelper.selectPointById(id);
            int expected = id;
            int result = resultPoint.getId();
            assertEquals(expected, result);
        } catch (NoPointWithGivenIdException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void selectAllPoints() {
        int expectedSize = 1;
        try {
            List<Point> points = new ArrayList<>(geometryDBHelper.selectAllPoints());
            int result = points.size();
            assertEquals(expectedSize, result);
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
}