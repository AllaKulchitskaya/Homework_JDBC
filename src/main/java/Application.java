import dao.CityDAO;
import dao.EmployeeDAO;
import dao.impl.CityDAOImpl;
import dao.impl.EmployeeDAOImpl;
import entity.City;
import entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();

        City city = new City("Krasnodar");

        Employee employee1 = new Employee("Tatyana", "Afanaseva", "female", 48, city);
        Employee employee2 = new Employee("Ivan", "Yastrebov", "male", 31, city);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        city.setEmployees(employees);

        cityDAO.createCity(city);

        employeeDAO.getAll().forEach(System.out::println);

        cityDAO.deleteCity(city);

        employeeDAO.getAll().forEach(System.out::println);

        City city1 = new City(6, "Sochi");
        cityDAO.updateCity(city1);

        employeeDAO.getAll().forEach(System.out::println);
    }
}
