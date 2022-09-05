package com.bridgelabz.springemployeepayrollappdevelopment_day5.services;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.repository.EmployeePayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    EmployeePayrollRepo employeePayrollRepo;
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(int id) {
        return employeePayrollList.get(id - 1);
    }

    public EmployeePayrollData createEmployeePayrollDataById(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
        return employeePayrollRepo.save(employeePayrollData);

    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        return null;
    }

    public EmployeePayrollData updateEmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(id);
        employeePayrollData.setName(employeePayrollData.name);
        employeePayrollData.setGender(employeePayrollData.gender);
        employeePayrollData.setSalary(employeePayrollData.salary);
        employeePayrollData.setNotes(employeePayrollData.notes);
        employeePayrollList.set(id - 1, employeePayrollData);
        return employeePayrollData;
    }

    public void deleteEmployeePayrollData(int id) {
        employeePayrollList.remove(id - 1);

    }
//    @Override
//    public ResponseDTO addEmployee(EmployeePayrollDTO employeeDTO) {
//        EmployeePayrollData employeePayrollDataObj = new EmployeePayrollData();
//        employeePayrollDataObj = employeePayrollRepo.save(employeePayrollDataObj);
//        if (employeePayrollDataObj != null) {
//            return new ResponseDTO("successfully inserted !!!!");
//        } else {
//            return new ResponseDTO("not success");
//        }
//    }
////    public ResponseDTO addEmployee(EmployeePayrollDTO employeePayrollDTO){
////        EmployeePayrollData employeePayrollDataObj = new EmployeePayrollData(employeePayrollDTO);
//////        String msg = "Hello" + " " +employeePayrollDTO.getName();
////        return employeePayrollDTO.save(employeePayrollDataObj);
////    }
//
//    @Override
//    public List<EmployeePayrollData> getEmployeeList() {
//        return employeePayrollRepo.findAll();
//    }
//
//    @Override
//    public ResponseDTO deleteEmployee(int id) {
//        employeePayrollRepo.deleteById(id);
//        return new ResponseDTO("Deleted successfully",);
//    }
//
//    @Override
//    public Optional<EmployeePayrollData> findEmployee(int id) {
//        return employeePayrollRepo.findById(id);
//    }
//    @Override
//    public EmployeePayrollData updateEmployeeData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
//        Optional<EmployeePayrollData> employeePayrollData= employeePayrollRepo.findById(employeeId);
//        return employeePayrollRepo.save(new EmployeePayrollData());
//    }
}
