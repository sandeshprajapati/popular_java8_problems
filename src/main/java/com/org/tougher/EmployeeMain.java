package com.org.tougher;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee("1", "Alice", null);
        Employee employee2 = new Employee("2", "Bob", "1");
        Employee employee3 = new Employee("3", "Charlie", "1");
        Employee employee4 = new Employee("4", "David", "2");
        Employee employee5 = new Employee("5", "Eve", "2");

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        // Group Employees by Manager ID and collect their names
        Map<String, List<String>> managerToEmployeeNames = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> Optional.ofNullable(e.getManagerId()).orElse("No Manager"),
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        // Print the result
        managerToEmployeeNames.forEach((managerId, employeeNames) -> {
            System.out.println("Manager ID: " + managerId);
            System.out.println("Employees: " + employeeNames);
        });
    }
}