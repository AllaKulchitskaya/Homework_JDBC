import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee("Kirill", "Sorokin", "male", 26, 3);
        employeeDAO.create(employee);

        System.out.println(employeeDAO.getById(6));

        List<Employee> employeesList = employeeDAO.getAll();
        for (Employee employee1 : employeesList) {
            System.out.println(employee1);
        }

        Employee employee2 = new Employee(7, "Ivan", "Yastrebov", "male", 31, 4);
        employeeDAO.update(employee2);

        employeeDAO.delete(employee2);
    }
}
