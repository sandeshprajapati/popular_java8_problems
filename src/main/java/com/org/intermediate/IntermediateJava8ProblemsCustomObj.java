package com.org.intermediate;

import com.org.Employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class IntermediateJava8ProblemsCustomObj {
    static List<Employee> list = new ArrayList<>();

    static {
        list = Arrays.asList(
                new Employee("John", "Male", 31, 1000, "IT", LocalDate.of(2025, 1, 25)),
                new Employee("Sandy", "Male", 35, 5000, "HR", LocalDate.of(2020, 4, 25)),
                new Employee("Rekha", "Female", 25, 3000, "IT", LocalDate.of(2022, 11, 25)),
                new Employee("Ajay", "Male", 33, 9000, "FIN", LocalDate.of(2026, 3, 25)),
                new Employee("John", "Male", 33, 1000, "IT", LocalDate.of(2021, 8, 25)),
                new Employee("Sweta", "Female", 31, 3000, "FIN", LocalDate.of(2019, 4, 25)));
    }

    public static void main(String[] args) {
        System.out.println("Sort a list of employees by salary");
        sortEmpBySalary(list);
        System.out.println("Group employees by department");
        groupBYDepartment(list);
        System.out.println("Find the highest-paid employee in each department");
        highestPaidEmployeeInEachDepartment(list);
        System.out.println("Calculate the average salary per department");
        avgPaidEmployeeInEachDepartment(list);
        System.out.println("=======List employees who joined after a certain date=========");
        listOfEmpJoinAfterDate(list);
        System.out.println("===Find employees with names starting with a specific letter===");
        listOfEmpStartWithLetter(list);
        System.out.println("==Count the number of employees in each department==");
        countEmpInEachDepartment(list);
        System.out.println("===List departments with more than a certain number of employees.===");
        listOfDepartmentMoreThen1Employee(list);
        System.out.println();
        System.out.println("===Find the youngest employee in the company==");
        youngestEmployee(list);
        System.out.println();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Use parallel streams to sum a large list of numbers");
        processLargeListCalSum();

    }

    private static void processLargeListCalSum() {
        final List<Long> longs = LongStream.rangeClosed(1, 100000L).boxed().collect(Collectors.toList());
        final long sum = longs.parallelStream().mapToLong(Long::longValue).sum();
        System.out.println(sum);

    }

    private static void youngestEmployee(List<Employee> list) {
        final int age = list.stream().mapToInt(Employee::getAge).min().orElse(0);
        System.out.println(age);
        final String name = list.stream().filter(e -> e.getAge() == age).map(Employee::getName).findFirst().orElse("");
        System.out.println(name);
        final Employee employee = list.stream().min(Comparator.comparingInt(Employee::getAge)).orElse(null);
        System.out.println(employee);
    }

    private static void listOfDepartmentMoreThen1Employee(List<Employee> list) {
        final List<String> list1 = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(list1);
    }

    private static void countEmpInEachDepartment(List<Employee> list) {
        final Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(map);
    }

    private static void listOfEmpStartWithLetter(List<Employee> list) {
        final List<Employee> list1 = list.stream().filter(e -> e.getName().startsWith("J")).collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

    private static void listOfEmpJoinAfterDate(List<Employee> list) {
        final List<Employee> list1 = list.stream().filter(e -> e.getDateOfJoining().isAfter(LocalDate.of(2023, 4, 25))).collect(Collectors.toList());
        list1.forEach(System.out::println);
    }

    private static void avgPaidEmployeeInEachDepartment(List<Employee> list) {
        final Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void highestPaidEmployeeInEachDepartment(List<Employee> list) {
        final Map<String, Optional<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
        map.forEach((k, v) -> System.out.println(k + "=" + v.orElse(null)));
    }

    private static void groupBYDepartment(List<Employee> list) {
        final Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void sortEmpBySalary(List<Employee> list) {
        final List<Employee> l = list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
        l.forEach(System.out::println);
    }
}
