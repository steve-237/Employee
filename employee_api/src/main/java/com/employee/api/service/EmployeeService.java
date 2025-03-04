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
     *
     * @param id
     * @return
     */
    public Optional<Employee> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    /**
     *
     * @return
     */
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    /**
     *
     * @param id
     */
    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    /**
     *
     * @param employee
     * @return
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
