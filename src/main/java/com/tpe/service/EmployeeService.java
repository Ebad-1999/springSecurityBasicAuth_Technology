package com.tpe.service;

import com.tpe.domain.Employee;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public void saveEmployee(Employee employee) {

        if(employeeRepository.existsByEmail(employee.getEmail())){
            throw new ConflictException("Employees whose email"+ employee.getEmail()+"already exist");
        }
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
         return employeeRepository.findAll();

    }


    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee Whose Id is " +id+"not found "));
        return employee;

    }
}
