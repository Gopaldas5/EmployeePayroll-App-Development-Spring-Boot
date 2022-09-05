package com.bridgelabz.springemployeepayrollappdevelopment_day5.services;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.repository.EmployeePayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    EmployeePayrollRepo employeePayrollRepo;
    public EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData employeePayrollDataObj = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepo.save(employeePayrollDataObj);
    }
    public Optional<EmployeePayrollData> findEmployeeID(int id){
        return employeePayrollRepo.findById(id);
    }
    public List<EmployeePayrollData> findAllEmployees(){
        return employeePayrollRepo.findAll();
    }

    public Integer deleteEmployeeID(int id) {
        employeePayrollRepo.deleteById(id);
        return id;
    }

}
