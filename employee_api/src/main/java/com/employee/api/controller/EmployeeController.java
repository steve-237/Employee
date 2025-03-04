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

    /**
     * Get the list of all employees
     * @return a list of all employees
     */
    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    /**
     * Create a new employee
     * @param employee - employee object to create
     * @return the new employee
     */
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    /**
     * Get an employee based on the id
     * @param id - id of the employee to retrieve
     * @return An object employee
     */
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") final Long id) {
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.orElse(null);
    }

    /**
     * Update an employee based on the id
     * @param id - id of the employee to be updated
     * @return An object employee
     */
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

    /**
     * Delete an employee
     * @param id of the employee to be deleted
     */
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id) {
        employeeService.deleteEmployee(id);
    }
}
