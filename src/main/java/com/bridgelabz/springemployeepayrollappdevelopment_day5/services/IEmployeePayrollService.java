package com.bridgelabz.springemployeepayrollappdevelopment_day5.services;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.ResponseDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int id);
    EmployeePayrollData createEmployeePayrollDataById(EmployeePayrollDTO employeePayrollDTO);
    EmployeePayrollData updateEmployeePayrollData( EmployeePayrollDTO employeePayrollDTO);
    void deleteEmployeePayrollData(int id);



//    ResponseDTO deleteEmployee(int id);
//
//    Optional<EmployeePayrollData> findEmployee(int id);
//
//    EmployeePayrollData updateEmployeeData(int employeeId, EmployeePayrollDTO employeeDTO);
}
