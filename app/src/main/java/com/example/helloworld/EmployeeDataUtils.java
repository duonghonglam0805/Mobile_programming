package com.example.helloworld;

public class EmployeeDataUtils {
    public static Employee[] getEmployees()  {
        Employee emp1 = new Employee("James", "Smith", "Receptionist", 1000);
        Employee emp2 = new Employee("Michael", "Garcia", "CEO", 50000);
        Employee emp3 = new Employee("Robert", "Johnson", "Professional staff", 2000);
        return new Employee[] {emp1, emp2, emp3};
    }
}
