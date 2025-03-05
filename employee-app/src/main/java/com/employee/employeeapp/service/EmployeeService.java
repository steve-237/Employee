package com.employee.employeeapp.service;

import com.employee.employeeapp.model.Employee;
import com.employee.employeeapp.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {

    @Autowired
    private EmployeeProxy employeeProxy;

    public Iterable<Employee> getEmployees() {
        return employeeProxy.getEmployees();
    }

    public Employee saveEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        if (employee.getLastName() != null) {
            employee.setLastName(employee.getLastName().toUpperCase());
        }

        return ((Integer) employee.getId() == null)
                ? employeeProxy.createEmployee(employee)
                : employeeProxy.updateEmployee(employee);
    }

    public Employee getEmployee(Integer id) {
        return employeeProxy.getEmployee(id);
    }

    public void deleteEmployee(Integer id) {
        employeeProxy.deleteEmployee(id);
    }

}
