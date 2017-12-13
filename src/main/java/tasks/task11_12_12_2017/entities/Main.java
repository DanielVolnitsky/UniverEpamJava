package tasks.task11_12_12_2017.entities;

import java.sql.SQLException;

public class Main {

    public static void main(String args[]) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        GeometrySQlHelper geometrySQlHelper = new GeometrySQlHelper();
        geometrySQlHelper.selectPointById(4);
    }
}
