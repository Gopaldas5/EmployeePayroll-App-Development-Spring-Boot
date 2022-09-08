package com.bridgelabz.springemployeepayrollappdevelopment_day5.controller;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.ResponseDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
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
        ResponseDTO responseDTO = new ResponseDTO( "Get call successful", iEmployeePayrollService);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        ResponseDTO responseDTO = new ResponseDTO( "Add employee payroll data successfully",
                iEmployeePayrollService.addEmployee(employeePayrollDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<ResponseDTO> findEmployeePayrollData(@PathVariable ("id") int id) {
        ResponseDTO responseDTO = new ResponseDTO( "find employee Id successful",
                iEmployeePayrollService.findEmployeeID(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/findAllEmployees")
    public List<EmployeePayrollData> findingAllEmployees() {
        return iEmployeePayrollService.findAllEmployees();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int id ,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO) {

        EmployeePayrollData employeePayrollDataObj = null;
        employeePayrollDataObj = iEmployeePayrollService.updateEmployeeById(id ,employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO( "Update employee payroll data successfully", employeePayrollDataObj);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Delete employee payroll data successfully",
                iEmployeePayrollService.deleteEmployeeById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
