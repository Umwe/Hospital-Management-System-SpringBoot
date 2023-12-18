package com.Umwe.hospitalmanagementsystem.Controller;

import com.Umwe.hospitalmanagementsystem.Model.Department;
import com.Umwe.hospitalmanagementsystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Create
    @PostMapping(value = "/saveDepartment")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        if (department != null) {
            Department createdDepartment = departmentService.saveDepartment(department);
            if (createdDepartment != null) {
                return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Read
    @GetMapping(value = "/listDepartments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/listDepartments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping(value = "/updateDepartment/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable String id, @RequestBody Department updatedDepartment) {
        Department department = departmentService.updateDepartment(id, updatedDepartment);
        if (department != null) {
            return new ResponseEntity<>("Department updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(value = "/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.NO_CONTENT);
    }
}
