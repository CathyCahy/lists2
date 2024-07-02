package ru.skypro.employee_demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping ("/departments")
@RestController

public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int department) {
        return departmentService.maxSalaryInDepartment(department);
    }
@GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int department) {
        return departmentService.minSalaryInDepartment(department);
    }
    @GetMapping("/all")
    public List<Employee> getAllEmpInDep(@RequestParam int department) {
        return departmentService.getAllEmp(department);
    }
@GetMapping("/all-grouped")
    public Map<Integer,List<Employee>> getAllEmployee() {
        return departmentService.getEmployeeOfDepartment();
    }


}
