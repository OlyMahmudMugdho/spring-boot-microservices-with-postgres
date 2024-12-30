package com.mahmud.department_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    Integer id;
    String name;
    List<Employee> employees = null;
}
