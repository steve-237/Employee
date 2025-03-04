package com.employee.api.service;

import com.employee.api.model.Employee;
import com.employee.api.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get an employee based on the id
     * @param id - of the employee
     * @return An object employee
     */
    public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    /**
     * Get the list of all employees
     * @return a list of all employees
     */
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Delete an employee
     * @param id of the employee to be deleted
     */
    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    /**
     * Save an employee in the Database
     * @param employee - employee saved
     * @return the Object employee saved
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
