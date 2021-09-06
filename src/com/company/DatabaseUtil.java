package com.company;

import java.sql.*;

public abstract class DatabaseUtil {

    public Connection getDbConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "toor");
    }

    public ResultSet execQuery(String sql) {

        if (sql == null || sql.trim().equals("")) {
            return null;
        }

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            return statement.executeQuery();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void execUpdate(String sql){

        if  (sql == null || sql.trim().equals(""))
            return;

        try {
            PreparedStatement statement = getDbConnection().prepareStatement(sql);
            statement.executeUpdate();

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
        return;
    }
}

