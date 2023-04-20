package org.example;

import java.sql.*;
import java.util.ArrayList;

public class AirportDAO {

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password123";


    public static void create(Airport airport) {
        String query = "INSERT INTO db.sb_airports (biz_name, address, city) VALUES (?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setString(1, airport.getBizName());
            statement.setString(2, airport.getAddress());
            statement.setString(3, airport.getCity());

            statement.executeUpdate();
            System.out.println("New entry created");
            statement.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to create a new entry. More:\n" + e.getMessage());
        }
    }

    public static ArrayList<Airport> searchByAirportName(String name) {
        String query = "SELECT * FROM db.sb_airports WHERE biz_name LIKE ?";
        ArrayList<Airport> airports = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%"+name+"%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int bizId = resultSet.getInt("biz_id");
                String bizName = resultSet.getString("biz_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");

                airports.add(new Airport(bizId, bizName, address, city));
            }
            System.out.println("query ran successfully");
        } catch (SQLException e) {
            System.out.println("Failed to run a query. More:\n" + e.getMessage());
        }
        return airports;
    }

    public static void update(Airport airport) {
        String query = "UPDATE db.sb_airports SET biz_name=?, address=?, city=? WHERE biz_id=?";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, airport.getBizName());
            statement.setString(2, airport.getAddress());
            statement.setString(3, airport.getCity());
            statement.setInt(4, airport.getBizId());
            statement.executeUpdate();
            System.out.println("Entry updated");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to update entry. More:\n" + e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM db.sb_airports WHERE biz_id=?";
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Entry deleted");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to delete entry. More:\n" + e.getMessage());
        }
    }
}
