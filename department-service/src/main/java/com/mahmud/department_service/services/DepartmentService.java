package com.mahmud.department_service.services;

import com.mahmud.department_service.clients.EmployeeClient;
import com.mahmud.department_service.models.Department;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    public List<Department> departments;

    @Autowired
    public EmployeeClient employeeClient;

    public DepartmentService(EmployeeClient employeeClient) {
        departments = new ArrayList<>();
        this.employeeClient = employeeClient;
    }

    public List<Department> getAllDepartments() {
        departments.forEach(department -> {
            department.setEmployees(
                    employeeClient.getEmployeeByDepartmentId(department.getId())
            );
        });
        return departments;
    }

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department getDepartmentById(int id) {
        return departments.stream()
                .filter(dept -> dept.getId() == id)
                .findFirst()
                .orElse(null);
    }


}
