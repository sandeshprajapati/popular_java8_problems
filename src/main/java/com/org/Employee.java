package com.org;

import java.time.LocalDate;

public class Employee {

    String name;
    String gender;
    int age;
    double salary;
    String department;
    LocalDate dateOfJoining;

    public Employee(String name, String gender, int age, double salary, String department, LocalDate dateOfJoining) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public  int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
