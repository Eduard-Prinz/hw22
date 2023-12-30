package mapDd.HW112.service;

import mapDd.HW112.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addsEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee removeEmployee(String firstName, String lastName, int salary, int departmentId);

    Employee findEmployee(String firstName, String lastName, int salary, int departmentId);

    Collection<Employee> findAll();

    Employee addsEmployee(String firstName, String lastName);

}