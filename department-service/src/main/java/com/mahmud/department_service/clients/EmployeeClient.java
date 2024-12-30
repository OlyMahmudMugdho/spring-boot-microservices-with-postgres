package com.mahmud.department_service.clients;

import com.mahmud.department_service.models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("/employees/department/{departmentId}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable int departmentId);
}
