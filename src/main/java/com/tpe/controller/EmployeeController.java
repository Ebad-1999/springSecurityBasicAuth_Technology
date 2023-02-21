package com.tpe.controller;

import com.tpe.domain.Employee;
import com.tpe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees") //http://localhost:8088/employees
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveEmployee(@Valid @RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        Map<String, String> map =new HashMap<>();
        map.put("message", "Employee is created successfully ");
        map.put("status", "true");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/id")  //http://localhost:8088/employees + get
    public ResponseEntity<List<Employee>> getAllEmployees(){
       List<Employee> employees= employeeService.getAllEmployee();
       return ResponseEntity.ok(employees);
    }


    @GetMapping("/query") //http://localhost:8088/employees/query?id=1 + get
    public ResponseEntity<Employee> getEmployeeById(@RequestParam("id") Long id){

        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
}
