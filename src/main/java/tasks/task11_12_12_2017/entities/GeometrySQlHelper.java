package tasks.task11_12_12_2017.entities;

import java.sql.*;
import java.util.Properties;

public class GeometrySQlHelper {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/geometry";

    private Properties properties;
    private Connection connection = null;
    private Statement statement = null;
    private Statement statement2 = null;
    private PreparedStatement preparedStatement = null;

    GeometrySQlHelper(/*String DBName, String ip, int port*/) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        initializeProperties();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection(CONNECTION_URL, properties);
        //stmt = con.createStatement();
    }

    /*добавляет точку*/
    void insertPoint(double x, double y) throws SQLException {
        statement = connection.createStatement();
        String insertStatement = "insert into points(x, y) values (" + x + ", " + y + ")";
        statement.executeUpdate(insertStatement);
    }

    /*добавляет полином*/
    void insertPolygon(String name) throws SQLException {
        System.out.println("connected polygon");
        preparedStatement = connection.prepareStatement("insert into polygons(name) values (?)");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }

    /*присваивает точку полиному*/
    void setPointToPolygon(int polygonID, int pointID) throws SQLException {
        statement = connection.createStatement();
        String setPolygonPoint = "insert into polygons_points(polygon_ID, point_ID) values " +
                "(" + polygonID + ", " + pointID + ")";
        statement.executeUpdate(setPolygonPoint);
    }

    /*удаляет полином и записи с его внешним ключем*/
    void deletePolygon(int polygonID) throws SQLException {
        statement = connection.createStatement();
        String deletePolygonReferences = "delete from polygons_points where polygon_ID = " + polygonID + "";
        String deletePolygon = "delete from polygons where ID = " + polygonID + "";
        statement.executeUpdate(deletePolygonReferences);
        statement.executeUpdate(deletePolygon);
    }

    /*удаляет точку и записи с ее внешним ключем*/
    void deletePoint(int pointID) throws SQLException {
        statement = connection.createStatement();
        String deletePointReferences = "delete from polygons_points where point_ID = " + pointID + "";
        String deletePoint = "delete from points where ID = " + pointID + "";
        statement.executeUpdate(deletePointReferences);
        statement.executeUpdate(deletePoint);
    }

    /*изменяет параметр x для точки*/
    void changePointParams(int pointID, double pointX) throws SQLException {
        statement = connection.createStatement();
        String changeX = "UPDATE points SET x = " + pointX + " WHERE ID = " + pointID + "";
        statement.executeUpdate(changeX);
    }

    /*изменяет параметры x, y для точки*/
    void changePointParams(int pointID, double pointX, double pointY) throws SQLException {
        statement = connection.createStatement();
        String changeX = "UPDATE points " +
                "SET x = " + pointX + "" +
                ",y = " + pointY + "" +
                "WHERE ID = " + pointID + "";
        statement.executeUpdate(changeX);
    }

    /*выводит точку по id*/
    void selectPointById(int pointID) throws SQLException {
        statement = connection.createStatement();
        String selPointByID = "Select ID,x,y from points where ID = " + pointID + "";
        ResultSet pointSet = statement.executeQuery(selPointByID);
        while (pointSet.next()){
            int pointId = pointSet.getInt("ID");
            int pointX = pointSet.getInt("x");
            int pointY = pointSet.getInt("y");
            System.out.print("ID: " + pointId + ", coordinates: (" + pointX + ", " + pointY + ")");
        }
    }

    /*выводит все полигоны и их точки*/
    void selectPolygonsPoints() {
        String selectPolygonsName = "select ID, name from polygons";
        String selectPolygonsPoints = "select x, y from points where ID in " +
                "(select point_ID from polygons_points where polygon_ID = ?)";
        try {
            statement = connection.createStatement();
            ResultSet polNamesSet = statement.executeQuery(selectPolygonsName);
            System.out.println("Список полигонов и их точек:");
            while (polNamesSet.next()) {
                int polId = polNamesSet.getInt("ID");
                String polName = polNamesSet.getString("name");
                System.out.print(polName + ": ");

                preparedStatement = connection.prepareStatement(selectPolygonsPoints);
                preparedStatement.setInt(1, polId);
                ResultSet polPointsSet = preparedStatement.executeQuery();
                while (polPointsSet.next()) {
                    int pointX = polPointsSet.getInt("x");
                    int pointY = polPointsSet.getInt("y");
                    System.out.print("(" + pointX + ", " + pointY + "), ");
                }
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

    // Завершение работы
    // public void stop() throws SQLException
    // {
    //         con.close();
    // }
}
