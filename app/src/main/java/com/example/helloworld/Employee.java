package com.example.helloworld;

import androidx.annotation.NonNull;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private int salary;

    public Employee (String firstName, String lastName, String position, int salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public String getFullName()  {
        return this.firstName + " " + this.lastName;
    }

    // Hiển thị spinner
    @Override
    public String toString()  {
        return this.getFullName() + " - (" + this.position+")";
    }
}
