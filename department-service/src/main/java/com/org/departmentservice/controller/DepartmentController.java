package com.org.departmentservice.controller;

import com.org.departmentservice.client.EmployeeClient;
import com.org.departmentservice.model.Department;
import com.org.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping()
    public Department add(@RequestBody Department department) {
        LOGGER.info("Save department");
        return departmentRepository.addDepartments(department);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Find all department");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Find department by id={}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Find all department");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(
                employeeClient.findByDepartmentId(department.getId())
        ));
        return departments;
    }

}
