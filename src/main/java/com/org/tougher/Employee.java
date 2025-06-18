package com.org.tougher;

class Employee {
    String id;
    String name;
    String managerId; // null if top-level

    public Employee(String id, String name, String managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", managerId='" + managerId + '\'' +
                '}';
    }
}

