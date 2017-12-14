package tasks.task11_12_12_2017.entities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import tasks.task11_12_12_2017.exceptions.NoPointWithGivenIdException;

import java.sql.*;
import java.util.*;

public class GeometryDBHelper {
    static Logger log = Logger.getLogger("GeometryDBHelper");

    static {
        new DOMConfigurator().doConfigure("src\\main\\resources\\log4j.xml", LogManager.getLoggerRepository());
    }

    private Properties properties;
    private String connection_url;
    private Connection conn;
    private Statement stmt;
    private PreparedStatement prepStmt = null;

    public GeometryDBHelper(String DBName, String ip, int port) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        initializeProperties();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection_url = "jdbc:mysql://" + ip + ":" + port + "/" + DBName;
        conn = DriverManager.getConnection(connection_url, properties);
        stmt = conn.createStatement();
    }

    /*добавляет точку*/
    public int insertPoint(double x, double y) throws SQLException {
        String sqlInsert = "insert into points(x, y) values (" + x + ", " + y + ")";
        try {
            int result = stmt.executeUpdate(sqlInsert);
            log.info("point (" + x + ", " + y + ") inserted successfully");
            return result;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*добавляет полином*/
    public int insertPolygon() throws SQLException {
        String sqlInsert = "insert into polygons() values ()";
        try {
            int result = stmt.executeUpdate(sqlInsert);
            log.info("polygon was inserted successfully");
            return result;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*присваивает точку полиному*/
    public int setPointToPolygon(int polygonID, int pointID) throws SQLException {
        try {
            String setPolygonPoint = "insert into polygons_points(polygon_ID, point_ID) values " +
                    "(" + polygonID + ", " + pointID + ")";
            int result = stmt.executeUpdate(setPolygonPoint);
            log.info("point with id " + pointID + " was set to polygon with id " + polygonID + " successfully");
            return result;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*присваивает точку полиному*/
    public int removePointFromPolygon(int polygonID, int pointID) throws SQLException {
        try {
            String remPolygonPoint = "delete from polygons_points where " +
                    "polygon_ID = " + polygonID + " and point_ID = " + pointID + "";
            int result = stmt.executeUpdate(remPolygonPoint);
            log.info("Entry where point with id " + pointID + " and " +
                    "polygon with id " + polygonID + " was deleted successfully");
            return result;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*удаляет полином и записи с его внешним ключем*/
    public int deletePolygon(int polygonID) throws SQLException {
        String deletePolygonReferences = "delete from polygons_points where polygon_ID = " + polygonID + "";
        String deletePolygon = "delete from polygons where ID = " + polygonID + "";
        try {
            stmt.executeUpdate(deletePolygonReferences);
            int result = stmt.executeUpdate(deletePolygon);
            log.info("polygon with id " + polygonID + " was deleted successfully");
            return result;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*удаляет точку и записи с ее внешним ключем*/
    public void deletePoint(int pointID) {
        String deletePointReferences = "delete from polygons_points where point_ID = " + pointID + "";
        String deletePoint = "delete from points where ID = " + pointID + "";
        try {
            stmt.executeUpdate(deletePointReferences);
            stmt.executeUpdate(deletePoint);
            log.info("point with id " + pointID + " was deleted successfully");
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    /*изменяет параметр x для точки*/
    public void changePointParams(int pointID, double pointX) {
        String updatePointX = "UPDATE points SET x = " + pointX + " WHERE ID = " + pointID + "";
        try {
            stmt.executeUpdate(updatePointX);
            log.info("point with id " + pointID + " was updated successfully");
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    /*изменяет параметры x, y для точки*/
    public void changePointParams(int pointID, double pointX, double pointY) {
        String changeCoords = "UPDATE points SET x = " + pointX + ",y = " + pointY + "" +
                "WHERE ID = " + pointID + "";
        try {
            stmt.executeUpdate(changeCoords);
            log.info("point with id " + pointID + " was updated successfully");
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }
    }

    /*выводит точку по id*/
    public Point selectPointById(int pointID) throws NoPointWithGivenIdException {
        Point point = null;
        int id, x, y;
        String selPointByID = "Select ID,x,y from points where ID = " + pointID + "";
        try {
            ResultSet pointSet = stmt.executeQuery(selPointByID);
            while (pointSet.next()) {
                id = pointSet.getInt("ID");
                x = pointSet.getInt("x");
                y = pointSet.getInt("y");
                point = new Point(id, x, y);
            }
            return point;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw new NoPointWithGivenIdException();
        }
    }

    /*выводит точку по x, y*/
    public Point selectPointByXY(double X, double Y) throws SQLException {
        Point point = null;
        int id, x, y;
        String selPointByXY = "Select ID,x,y from points where x = " + X + " and y = " + Y + "";
        try {
            ResultSet pointSet = stmt.executeQuery(selPointByXY);
            while (pointSet.next()) {
                id = pointSet.getInt("ID");
                x = pointSet.getInt("x");
                y = pointSet.getInt("y");
                point = new Point(id, x, y);
            }
            return point;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*выводит все точки*/
    public List<Point> selectAllPoints() throws SQLException {
        List<Point> result = new ArrayList<>();
        String query = "select ID,x,y from points";
        try {
            ResultSet pointSet = stmt.executeQuery(query);
            while (pointSet.next()) {
                int pointId = pointSet.getInt("ID");
                int pointX = pointSet.getInt("x");
                int pointY = pointSet.getInt("y");
                result.add(new Point(pointId, pointX, pointY));
                System.out.print("ID: " + pointId + ", coordinates: (" + pointX + ", " + pointY + ")\n");
            }
            return result;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    /*выводит все полигоны и их точки*/
    public Map<Polygon, List<Point>> selectPolygonsWithTheirPoints() throws SQLException {
        Map<Polygon, List<Point>> polsWithPoints = new HashMap<>();
        String selectPolygonsID = "select ID from polygons";
        String selectPolygonsPoints = "select ID, x, y from points where ID in " +
                "(select point_ID from polygons_points where polygon_ID = ?)";
        try {
            ResultSet polNamesSet = stmt.executeQuery(selectPolygonsID);
            while (polNamesSet.next()) {
                int polId = polNamesSet.getInt("ID");
                Polygon pol = new Polygon(polId);
                prepStmt = conn.prepareStatement(selectPolygonsPoints);
                prepStmt.setInt(1, polId);
                ResultSet polPointsSet = prepStmt.executeQuery();
                List<Point> polPoints = new ArrayList<>();
                System.out.print("Polygon " + polId + " : ");
                while (polPointsSet.next()) {
                    int pointId = polPointsSet.getInt("ID");
                    int pointX = polPointsSet.getInt("x");
                    int pointY = polPointsSet.getInt("y");
                    polPoints.add(new Point(pointId, pointX, pointY));
                    System.out.print("[" + pointX + ", " + pointY + "]; ");
                }
                polsWithPoints.put(pol, polPoints);
                System.out.println();
            }
            return polsWithPoints;

        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    public Polygon getPolygonById(int id) throws SQLException {
        Polygon polygon = new Polygon();
        String selectPolygonById = "select ID from polygons WHERE ID = " + id + "";
        try {
            ResultSet resultSet = stmt.executeQuery(selectPolygonById);
            while (resultSet.next()) {
                int polId = resultSet.getInt("ID");
                polygon.setId(polId);
            }
            return polygon;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    private void initializeProperties() {
        properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "1123581321");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");
        properties.setProperty("useJDBCCompliantTimezoneShift", "true");
        properties.setProperty("useLegacyDatetimeCode", "false");
        properties.setProperty("serverTimezone", "UTC");
    }

    /*Завершение работы*/
    public void stop() throws SQLException {
        conn.close();
    }
}
