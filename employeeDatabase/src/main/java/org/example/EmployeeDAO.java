package org.example;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://127.0.0.1:3307/employeedb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password123";

    public static void create(Employee employee) {
        String query = "INSERT INTO employeedb.employee (name, surname, salary) VALUES (?,?,?)";

        try {
            Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = c.prepareStatement(query);

            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setDouble(3, employee.getSalary());

            statement.executeUpdate();
            System.out.println("New entry created");
            statement.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Failed to create a new entry. More:\n" + e.getMessage());
        }
    }

    public static ArrayList<Employee> showAllEntries() {
        String query = "SELECT * FROM employee";
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = c.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                double salary = resultSet.getDouble("salary");

                employees.add(new Employee(name, surname, salary));
            }
            statement.close();
            c.close();
            System.out.println("query ran successfully");
        } catch (SQLException e) {
            System.out.println("Failed when searching for all entries, more:\n" + e.getMessage());
        }
        return employees;
    }
    public static ArrayList<Employee> searchByEmployeeName(String name) {
       ArrayList<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee WHERE name LIKE ?";

        try {
            Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, "%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ename = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                double salary = resultSet.getDouble("salary");

                employees.add(new Employee(ename, surname, salary));
            }
            statement.close();
            c.close();
            System.out.println("query ran successfully");
        } catch (SQLException e) {
            System.out.println("Failed when searching for employees by name, more:\n" + e.getMessage());
        }
        return employees;
    }

    public static void update(Employee employee) {
        String query = "UPDATE employeedb.employee SET name=?, surname=?, salary=? WHERE id=?";
        try {
            Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
            System.out.println("Entry updated");
            statement.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Failed to update entry. More:\n" + e.getMessage());
        }
    }
    public static void delete(int id) {
       String query = "DELETE FROM employeedb.employee WHERE id=?";
       try {
           Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           PreparedStatement statement = c.prepareStatement(query);
           statement.setInt(1, id);
           statement.executeUpdate();
           System.out.println("Entry deleted");
           statement.close();
           c.close();
       } catch (SQLException e) {
           System.out.println("Failed to delete entry. More:\n" + e.getMessage());
       }
    }
    public static int countEntriesByName(String name) {
        String query = "SELECT COUNT(name) as count FROM employee WHERE name LIKE ?";
        int count = 0;
        try {
            Connection c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = c.prepareStatement(query);
            statement.setString(1, "%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            System.out.println("query ran successfully");
            statement.close();
            c.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong executing a query. More:\n" + e.getMessage());
        }
        return count;
    }
}
