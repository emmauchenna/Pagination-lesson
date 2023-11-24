package com.kloudvista.pagenation.service;

import com.kloudvista.pagenation.domain.Employee;
import com.kloudvista.pagenation.repository.EmployeeRepository;
import com.kloudvista.pagenation.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> getEmployees(int pageNo , int pageSize, String direction, String sort) {
        if(direction.toUpperCase() != "ASC" || direction.toUpperCase() != "DESC"){
            direction = "ASC";
        }
        log.info("theheh");
        log.debug("jdddk");
        log.info("jdjdkdjk");

       PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.Direction.valueOf(direction.toUpperCase()), String.valueOf(Sort.by(sort)));

        Page<Employee> all = employeeRepository.findAll(pageRequest);
        return all;
    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }
}
