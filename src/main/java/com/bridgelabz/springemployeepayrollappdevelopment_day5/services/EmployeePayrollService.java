package com.bridgelabz.springemployeepayrollappdevelopment_day5.services;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.email.EmailService;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.exception.CustomException;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.repository.EmployeePayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepo employeePayrollRepo;

    @Autowired
    EmailService emailService;


    //Method to add new employee details to database.
    public EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollDataObj = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepo.save(employeePayrollDataObj);
    }

    public Optional<EmployeePayrollData> findEmployeeID(int id) {
        if (employeePayrollRepo.findById(id).isPresent()) {
            return employeePayrollRepo.findById(id);
        } else {
            throw new CustomException("Employee id not found");
        }
    }

    public List<EmployeePayrollData> findAllEmployees() {
        if (employeePayrollRepo.findAll().isEmpty()) {
            return employeePayrollRepo.findAll();
        } else {
            throw new CustomException("Employee data is empty");
        }
    }
     @Override
    public EmployeePayrollData updateEmployeeById(int id, EmployeePayrollDTO employeePayrollDTO) {
         if (employeePayrollRepo.findById(id).isPresent()) {
            EmployeePayrollData employeePayrollDataObj = employeePayrollRepo.findById(id).get();
            System.out.println(employeePayrollDataObj);
            employeePayrollDataObj.setFirstName(employeePayrollDTO.getFirstName());
            employeePayrollDataObj.setLastName(employeePayrollDTO.getLastname());
            employeePayrollDataObj.setSalary(employeePayrollDTO.getSalary());
            employeePayrollRepo.save(employeePayrollDataObj);
            return ResponseEntity.ok(employeePayrollDataObj).getBody();
               return ResponseEntity.ok(employeePayrollDataObj).getBody();
        } else {
            throw new CustomException("Employee id not found, Insert correct id");
        }
    }

    public EmployeePayrollData addEmployeeEmail(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        employeePayrollRepo.save(employeePayrollData);
        emailService.sendEmail(employeePayrollDTO.getEmail(), "Account sign up Successfully", "Hello " + employeePayrollData.getFirstName() +" "+ employeePayrollData.getLastName());
        return employeePayrollRepo.save(employeePayrollData);
    }

    public Integer deleteEmployeeById(int id) {
        if (employeePayrollRepo.existsById(id)) {
            employeePayrollRepo.deleteById(id);
            return id;
        } else {
            throw new CustomException("Id is not found , Insert correct id number! ");
        }
    }

}
