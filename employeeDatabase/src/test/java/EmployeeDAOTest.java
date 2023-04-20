import org.example.Employee;
import org.example.EmployeeDAO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAOTest {

    private static final String URL = "jdbc:mysql://127.0.0.1:3307/employeedb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password123";
    Connection connection = null;
    PreparedStatement statement = null;
    Employee mockEmployee = new Employee();
    String name = null;
    String surname = null;
    double salary = 0;
    String createPositiveQuery = null;

    @Before
    public void setUp() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Something went wrong:\n" + e.getMessage());
        }

        name = "testEmployeeName";
        surname = "testEmployeeSurname";
        salary = 100000;
        mockEmployee.setName(name);
        mockEmployee.setSurname(surname);
        mockEmployee.setSalary(salary);

        createPositiveQuery = "SELECT COUNT(*) as count FROM employeedb.employee WHERE name=? AND surname=? AND salary=?";
    }

    @Test
    public void createPositiveTest() {
        EmployeeDAO.create(mockEmployee);
        int count = 0;
        try {
            statement = connection.prepareStatement(createPositiveQuery);
            statement.setString(1, mockEmployee.getName());
            statement.setString(2, mockEmployee.getSurname());
            statement.setDouble(3, mockEmployee.getSalary());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in createPositiveTest:\n" + e.getMessage());
        }
        Assert.assertTrue(0 < count);
    }

    @Test
    public void createNegativeTest() {
        EmployeeDAO.create(mockEmployee);
        int count = 0;
        try {
            statement = connection.prepareStatement(createPositiveQuery);
            statement.setString(1, mockEmployee.getName());
            statement.setString(2, mockEmployee.getSurname());
            statement.setDouble(3, mockEmployee.getSalary());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in createPositiveTest:\n" + e.getMessage());
        }
        Assert.assertFalse(0 >= count);
    }

    @Test
    public void searchByNamePositiveTest() {
        EmployeeDAO.create(mockEmployee);
        ArrayList<Employee> employees = new ArrayList<>();
        Assert.assertTrue(employees.isEmpty());
        employees = EmployeeDAO.searchByEmployeeName(mockEmployee.getName());
        //TODO you are here, implement this test and move on
        Assert.assertTrue(employees.isEmpty());
    }

    @Test
    public void searchByNameNegativeTest() {
    }

    @Test
    public void updatePositiveTest() {
    }

    @Test
    public void updateNegativeTest() {
    }

    @Test
    public void deletePositiveTest() {
    }

    @Test
    public void deleteNegativeTest() {
    }

    @After
    public void tearDown() {
        String query = "DELETE FROM employeedb.employee WHERE name=? AND surname=? AND salary=?";
        try {
            Connection connection1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement1 = connection1.prepareStatement(query);
            statement1.setString(1, mockEmployee.getName());
            statement1.setString(2, mockEmployee.getSurname());
            statement1.setDouble(3, mockEmployee.getSalary());
            statement1.executeUpdate();
            statement1.close();
            connection1.close();
        } catch (SQLException e) {
            System.out.println("Error on teardown:\n" + e.getMessage());
        }
    }
}
