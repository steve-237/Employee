package com.employee.api.controller;

import com.employee.api.model.Employee;
import com.employee.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
        Optional<Employee> employeeOptional = employeeService.getEmployee(id);
        if (employeeOptional.isPresent()) {
            Employee employeeToUpdate = employeeOptional.get();

            String firstName = employee.getFirstName();
            if(firstName != null && !firstName.isEmpty()) {
                employeeToUpdate.setFirstName(firstName);
            }

            String lastName = employee.getLastName();
            if(lastName != null && !lastName.isEmpty()) {
                employeeToUpdate.setLastName(lastName);
            }

            String mail = employee.getMail();
            if(mail != null && !mail.isEmpty()) {
                employeeToUpdate.setMail(mail);
            }

            String password = employee.getPassword();
            if(password != null && !password.isEmpty()) {
                employeeToUpdate.setPassword(password);
            }
            employeeService.saveEmployee(employeeToUpdate);
            return employeeToUpdate;
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }
}
