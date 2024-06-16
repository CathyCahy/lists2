package ru.skypro.employee_demo1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service

public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Павел", "Дуров"),
            new Employee("Валерий", "Дуров"),
            new Employee("Сергей", "Зверев")
//            new Employee("Василий", "Васильев"),
//            new Employee("Иннокентий", "Старцев"),
//            new Employee("Люси", "Маклин"),
//            new Employee("Куп", "Говард"),
//            new Employee("Павел", "Дуров"),
//            new Employee("Максимус", "Рыцарь"),
//            new Employee("Ли", "Молдэйвер"),
//            new Employee("Барб", "Говард"),
//            new Employee("Стеф", "Харпер"),
//            new Employee("Бетти", "Пирсон")
    ));

    int maxEmployee = 14;

    public void add(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        if (employeeList.size() >= maxEmployee) {
            // System.out.println("Нельзя добавить сотрудника, штат заполнен");
            throw new EmployeeStorageIsFullException();
        }
        if (employeeList.contains(emp)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeList.add(emp);
    }

    public void remove(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(emp)) {
                employeeList.remove(employeeList.get(i));
                return;
            }

            throw new EmployeeNotFoundException();

        }
    }

    public Employee find(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(emp)) {

                return emp;
            }
        }

        throw new EmployeeNotFoundException();

    }

    public Collection getAll(){
        return employeeList;
    }
}