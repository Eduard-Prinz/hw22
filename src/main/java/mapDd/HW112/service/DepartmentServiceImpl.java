package mapDd.HW112.service;

import org.springframework.stereotype.Service;
import mapDd.HW112.Exception.EmployeeNotFoundException;
import mapDd.HW112.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.departmentId() == departmentId)
                .max(comparingInt(Employee::salary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.departmentId() == departmentId)
                .min(comparingInt(Employee::salary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartmentSortedByNameSurName() {
        return employeeService
                .findAll()
                .stream()
                .sorted(comparing(Employee::lastName)
                        .thenComparing(Employee::firstName))
                .collect(groupingBy(Employee::departmentId));
    }


    @Override
    public Collection<Employee> findEmployeesByDepartmentSortedByNameSurName(int departmentId) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.departmentId() == departmentId)
                .sorted(comparing(Employee::lastName)
                        .thenComparing(Employee::firstName))
                .collect(toList());
    }

    public Map<String, Double> userGroupByTest() {
        return employeeService
                .findAll()
                .stream()
                .collect(groupingBy(Employee::lastName, Collectors.averagingInt(Employee::salary)));
    }
}