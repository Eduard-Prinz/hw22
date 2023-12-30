package mapDd.HW112.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import mapDd.HW112.model.Employee;
import mapDd.HW112.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departamentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departamentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartmentId(@RequestParam int departmentId) {
        return departamentService.findEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartmentId(@RequestParam int departmentId) {
        return departamentService.findEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departamentService.findEmployeesByDepartmentSortedByNameSurName();
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> findEmployees(@RequestParam int departmentId) {
        return departamentService.findEmployeesByDepartmentSortedByNameSurName(departmentId);
    }
}