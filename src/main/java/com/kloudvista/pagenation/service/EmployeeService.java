package com.kloudvista.pagenation.service;

import com.kloudvista.pagenation.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> getEmployees(int pageNo , int pageSize, String direction, String sort);
    List<Employee> getEmployees();
}
