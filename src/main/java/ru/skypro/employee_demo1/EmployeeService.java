package ru.skypro.employee_demo1;

import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class EmployeeService {
    int maxEmployee = 14;
    private final Map<String, Employee> employeeMap = new HashMap<>(maxEmployee);
//            new Employee("Иван", "Иванов"),
//           "234", new Employee("Петр", "Петров"),
//            "456", new Employee("Павел", "Дуров"),
//           "567", new Employee("Валерий", "Дуров"),
//            "678",new Employee("Сергей", "Зверев")
////            new Employee("Василий", "Васильев"),
////            new Employee("Иннокентий", "Старцев"),
////            new Employee("Люси", "Маклин"),
////            new Employee("Куп", "Говард"),
////            new Employee("Павел", "Дуров"),
////            new Employee("Максимус", "Рыцарь"),
////            new Employee("Ли", "Молдэйвер"),
////            new Employee("Барб", "Говард"),
////            new Employee("Стеф", "Харпер"),
////            new Employee("Бетти", "Пирсон")
//    );


    public Employee add(String firstName, String lastName, int department, double salary) {

        Employee emp = new Employee(firstName, lastName, department, salary);
        var key = makeKey(firstName, lastName);
        if (employeeMap.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        if (employeeMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(key, emp);
        return emp;
    }

    public void remove(String firstName, String lastName) {
        var key = makeKey(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            employeeMap.remove(key);
            return;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) {
        var key = makeKey(firstName, lastName);
        Employee emp = employeeMap.get(key);
        if (emp != null) {
            return employeeMap.get(key);
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAll() {

        return employeeMap.values();
    }

    public String print(Employee employee) {
        return employee.toString();
    }

    private static String makeKey(String firstName, String lastName) {
        return (firstName + "_" + lastName).toLowerCase();
    }

}