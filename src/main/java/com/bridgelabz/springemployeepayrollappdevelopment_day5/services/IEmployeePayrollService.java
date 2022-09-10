package com.bridgelabz.springemployeepayrollappdevelopment_day5.services;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;

import java.util.List;
import java.util.Optional;


public interface IEmployeePayrollService {

     EmployeePayrollData addEmployee(EmployeePayrollDTO greetingDTO);

    Optional<EmployeePayrollData> findEmployeeID(int id);

    List<EmployeePayrollData> findAllEmployees();

    EmployeePayrollData updateEmployeeById(int id, EmployeePayrollDTO employeePayrollDTO);

    Integer deleteEmployeeById(int id);

    EmployeePayrollData addEmployeeEmail(EmployeePayrollDTO employeePayrollDTO);
}
