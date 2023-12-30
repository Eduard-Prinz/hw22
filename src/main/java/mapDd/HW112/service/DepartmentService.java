package mapDd.HW112.service;

import mapDd.HW112.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalary(int departmentId);
    Employee findEmployeeWithMinSalary(int departmentId);
    Map<Integer, List<Employee>> findEmployeesByDepartmentSortedByNameSurName();
    Collection<Employee> findEmployeesByDepartmentSortedByNameSurName(int departmentId);
}