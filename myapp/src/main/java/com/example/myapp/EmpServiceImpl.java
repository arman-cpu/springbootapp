package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository emprepo;
    // creating list to store employees..
    // List<Employee> employees = new ArrayList<>();

    // inheriting all the abstract methods from service interface...
    @Override
    public String CreateEmp(Employee employee) {
        EmpEntity emptty = new EmpEntity();
        BeanUtils.copyProperties(employee, emptty);
        emprepo.save(emptty);
        // employees.add(employee);
        return "Saved successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmpEntity> employeslist = emprepo.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmpEntity E : employeslist) {
            Employee emp = new Employee();
            emp.setId(E.getId());
            emp.setName(E.getName());
            emp.setPhone(E.getPhone());
            emp.setEmail(E.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmpEntity emp = emprepo.findById(id).get();
        emprepo.delete(emp);
        return true;

    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmpEntity existingEmp = emprepo.findById(id).get();
        existingEmp.setEmail(employee.getEmail());
        existingEmp.setName(employee.getName());
        existingEmp.setPhone(employee.getPhone());

        emprepo.save(existingEmp);
        return "Updated Successfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmpEntity emp = emprepo.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp, employee);

        return employee;
    }

}
