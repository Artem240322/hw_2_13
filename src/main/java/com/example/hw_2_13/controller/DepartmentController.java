package com.example.hw_2_13.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestParam("/departmens")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {this.departmentService = departmentService; }


    @GetMapping("/max-salary")
    public Employee employeeWithMaxSalaryFromDepartment(@RequestParam int departmentId) {
        return departmentService.employeeWithMaxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee employeeWithMaxSalaryFromDepartment(@RequestParam int departmentId) {
        return  departmentService.employeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> employeeFromDepartment(@RequestParam int departmentId) {
        return departmentService.employeesFromDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> employeesGroupedByDepartment() {
        return departmentService.emploeesGroupedByDepartment();
    }

}
