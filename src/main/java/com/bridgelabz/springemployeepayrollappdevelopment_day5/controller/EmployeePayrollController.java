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

// Creating the REST controller class
@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService iEmployeePayrollService;


    @GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        ResponseDTO responseDTO = new ResponseDTO("Get call successful", iEmployeePayrollService);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Create a POST method to add an employeePayroll to the list

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Add employee payroll data successfully",
                iEmployeePayrollService.addEmployee(employeePayrollDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Create a Get method to find an employeePayrollData to the list
    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<ResponseDTO> findEmployeePayrollData(@PathVariable("id") int id) {
        ResponseDTO responseDTO = new ResponseDTO("find employee Id successful",
                iEmployeePayrollService.findEmployeeID(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Create a Get method to find all employee data to the list
    @GetMapping("/findAllEmployees")
    public List<EmployeePayrollData> findingAllEmployees() {
        return iEmployeePayrollService.findAllEmployees();
    }

    // Create a Put  method to update  employee data  by using id to the list.
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int id,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO) {

        EmployeePayrollData employeePayrollDataObj = null;
        employeePayrollDataObj = iEmployeePayrollService.updateEmployeeById(id, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Update employee payroll data successfully", employeePayrollDataObj);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Create a Post method to add email of  employees to the list.
    @PostMapping("/email")
    public ResponseEntity<ResponseDTO> addEmployeeEmail(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        ResponseDTO responseDTO = new ResponseDTO("EmployeeData email added successfully", iEmployeePayrollService.addEmployeeEmail(employeePayrollDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    //Create a Delete method to delete  employees data from the list.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Delete employee payroll data successfully",
                iEmployeePayrollService.deleteEmployeeById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
