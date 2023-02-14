import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import jdbc.ConnectionManager;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1, 4);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstName = "Имя: " + resultSet.getString("first_name");
                String lastName = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println("Возраст: " + age + " лет");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Задание 2");

        try (Connection connection = ConnectionManager.getConnection()) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City city = new City(1, "Saint-Petersburg");
            Employee employee = new Employee("Olga", "Menshova", "female", 42, city);

            employeeDAO.create(employee);

            List<Employee> employeesList = new ArrayList<>(employeeDAO.getAll());
            for (Employee employee1 : employeesList) {
                System.out.println(employee1);
            }

            System.out.println(employeeDAO.getById(6));

            employeeDAO.updateById(1, 39);

            employeeDAO.deleteById(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
