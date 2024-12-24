package com.example.myapp;

// import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmpController {
    // List<Employee> employees = new ArrayList<>();
    // creating object empserv with empserviceimpl class constructor.
    // EmpService empserv = new EmpServiceImpl();

    // dependency injection
    @Autowired
    EmpService empserv;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return empserv.readEmployees();

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {

        return empserv.readEmployee(id);
    }

    @PostMapping("/employees")
    public String CreateEmp(@RequestBody Employee employee) {
        // employees.add(employee);
        return empserv.CreateEmp(employee);

    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (empserv.deleteEmployee(id))
            return "Deleted successfully";
        return "Not found";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

        return empserv.updateEmployee(id, employee);
    }

}
