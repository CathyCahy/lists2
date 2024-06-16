package ru.skypro.employee_demo1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    List<Employee> employeeList = List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Павел", "Дуров")
    );

    int maxEmployee = 15;

    public void addEmployee(String firstName, String lastName) {

        if (employeeList.size() >= maxEmployee) {
            // System.out.println("Нельзя добавить сотрудника, штат заполнен");
            throw new EmployeeStorageIsFullException();
        }
        Employee emp = new Employee(firstName, lastName);
        if (findEmployee(firstName, lastName)) {
            throw new EmployeeAlreadyAddedException();
        }

        employeeList.add(employeeList.size() + 1, new Employee(firstName, lastName));

    }

    public void removeEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName,lastName);
        for (int i = 0; i < employeeList.size(); i++) {

            if (employeeList.get(i).equals(emp)) {
                employeeList.remove(employeeList.get(i));
            }
            if (!findEmployee(firstName,lastName)) {
                throw new EmployeeNotFoundException();
            }
        }
    }

    public boolean findEmployee(String firstName, String lastName) {
        Employee emp = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).equals(emp)) {
                System.out.println("Сотрудник с именем " + firstName + " и фамилией " + lastName + " найден: " + employeeList.get(i));
                return true;
            }
            //System.out.println(emp.getFirstName() + " " + emp.getLastName() + " не найден!");

            throw new EmployeeNotFoundException();

        }

        return false;
    }
}
