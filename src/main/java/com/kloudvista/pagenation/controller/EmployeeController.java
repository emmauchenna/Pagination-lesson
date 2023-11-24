package com.kloudvista.pagenation.controller;

import com.kloudvista.pagenation.service.EmployeeServiceImpl;
import com.kloudvista.pagenation.domain.Employee;
import org.hibernate.boot.model.source.spi.CascadeStyleSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeedb;



    @GetMapping("/get-all")
    public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam Optional<Integer> pageNo,
                                                         @RequestParam Optional<Integer> pageSize,
                                                         @RequestParam Optional<String> direction,
                                                         @RequestParam Optional<String> sortBy){

        Page<Employee> employees = employeedb.getEmployees(pageNo.orElse(0), pageSize.orElse(5),
                direction.orElse("ASC").toUpperCase(), sortBy.orElse("id"));

        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("/get-all-employee")
    public ResponseEntity<Page<Employee>> getAllEmployee(@RequestParam int pageNo,
                                                         @RequestParam int pageSize,
                                                         @RequestParam String direction,
                                                         @RequestParam String sortBy){


        Page<Employee> employees = employeedb.getEmployees(pageNo, pageSize, direction.toUpperCase(), sortBy);

        return new ResponseEntity<>(employees, HttpStatus.OK);

    }

    @GetMapping("/get-employee")
    public ResponseEntity<List<Employee>> getAllEmployees(){

       List<Employee> employees = employeedb.getEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);

    }


}
