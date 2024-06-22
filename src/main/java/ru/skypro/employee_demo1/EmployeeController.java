package ru.skypro.employee_demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/employee")
@RestController


public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в отдел кадров";
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
       return employeeService.add(firstName, lastName);

    }

    @GetMapping("/remove")
    public void remove(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);

    }

    @GetMapping("/all")
    public Collection<Employee> getAll() {
        return employeeService.getAll();

    }

}
