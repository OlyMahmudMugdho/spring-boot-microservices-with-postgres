package com.mahmud.employee_service.services;

import com.mahmud.employee_service.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceInMemory implements IEmployeeService {
    private List<Employee> employees;

    public EmployeeServiceInMemory() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartmentId()==departmentId)
                .toList();
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
}
