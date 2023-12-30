package mapDd.HW112.service;


import mapDd.HW112.Exception.EmployeeAlreadyAddedException;
import mapDd.HW112.Exception.EmployeeNotFoundException;
import mapDd.HW112.model.Employee;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }



    @Override
    public Employee addsEmployee(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.firstName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.firstName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.firstName())) {
            employees.remove(employee.firstName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int departmentId) {
        Employee employee = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employee.firstName())) {
            return employees.get(employee.firstName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee addsEmployee(String firstName, String lastName) {
        return null;
    }
}