package ru.skypro.employee_demo1;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // методы по работе с отделами и зп
    //#1
    public Employee maxSalaryInDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(e -> department == e.getDepartment()).
                max(Comparator.comparingDouble(Employee::getSalary)).
                orElse(null);
    }
    //#2
    public Employee minSalaryInDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(e -> department == e.getDepartment()).
                min(Comparator.comparingDouble(Employee::getSalary)).
                orElse(null);
    }

    //#3
    public List<Employee> getAllEmp (int department) {
        return employeeService.getAll().stream()
                .filter(e->e.getDepartment()==department)
                .toList();
    }

    //#4
    public Map<Integer,List<Employee>> getEmployeeOfDepartment(){
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

