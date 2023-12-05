package com.stackroute.service;

import com.stackroute.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class TriggerClass {

    public String getEmployeeId(Employee employee) {
        return employee.getId();
    }

    public String getEmployeeName(Employee employee) {
        return employee.getName();
    }
}
