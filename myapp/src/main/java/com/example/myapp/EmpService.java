package com.example.myapp;

import java.util.List;

//creating service interface class

public interface EmpService {

    // creating abstract methods as interface class contains abs methods
    String CreateEmp(Employee employee);

    List<Employee> readEmployees();

    boolean deleteEmployee(Long id);

    String updateEmployee(Long id, Employee employee);

    Employee readEmployee(Long id);
}
