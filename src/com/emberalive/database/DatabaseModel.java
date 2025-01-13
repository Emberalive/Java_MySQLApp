package com.emberalive.database;

import com.emberalive.database.views.RentalView;

import java.sql.*;

public class DatabaseModel {
    private static final String DB_URL = "jdbc:mysql://165.227.235.122:3306/ss2979_sussex_test";
    private static final String USER = "ss2979_app_user";
    private static final String PASSWORD = "QwErTy1243!";
    private Connection connection;

    // Establish connection to the database
    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Execute a query and return the result as a ResultSet
    public ResultSet executeQuery(String query) throws SQLException {
        if (connection == null) {
            throw new SQLException("Not connected to the database.");
        }
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    // Close the database connection
    public void disconnect(RentalView view) {
        try {
            if (connection != null) {
                connection.close();
                view.getConnectButton().setEnabled(true);
                view.getDisconnectButton().setEnabled(false);
                view.getStatusLabel().setText("Disconnected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
