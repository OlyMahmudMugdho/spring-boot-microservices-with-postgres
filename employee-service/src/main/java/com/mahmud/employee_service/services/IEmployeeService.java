package com.mahmud.employee_service.services;

import com.mahmud.employee_service.models.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    List<Employee> getEmployeesByDepartmentId(int departmentId);
    Employee addEmployee(Employee employee);
}
