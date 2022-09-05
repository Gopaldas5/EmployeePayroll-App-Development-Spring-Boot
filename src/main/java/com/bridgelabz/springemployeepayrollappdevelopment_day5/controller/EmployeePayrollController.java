package com.bridgelabz.springemployeepayrollappdevelopment_day5.controller;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.ResponseDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.services.EmployeePayrollService;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
  @Autowired
  IEmployeePayrollService iEmployeePayrollService;


    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = iEmployeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("id") int id) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = iEmployeePayrollService.getEmployeePayrollDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Get call Id successful", id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = iEmployeePayrollService.createEmployeePayrollDataById(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Create employee payroll data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("id") int id, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = iEmployeePayrollService.updateEmployeePayrollData(employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update employee payroll data successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("id") int id) {
        iEmployeePayrollService.deleteEmployeePayrollData(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete employee payroll data successfully", +id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
}
