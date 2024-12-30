package com.mahmud.employee_service.controllers;

import com.mahmud.employee_service.models.Employee;
import com.mahmud.employee_service.services.EmployeeService;
import com.mahmud.employee_service.services.EmployeeServiceInMemory;
import com.mahmud.employee_service.services.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/employees","/employees/"})
@CrossOrigin("*")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeeByDepartmentId(@PathVariable int departmentId) {
        return employeeService.getEmployeesByDepartmentId(departmentId);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
