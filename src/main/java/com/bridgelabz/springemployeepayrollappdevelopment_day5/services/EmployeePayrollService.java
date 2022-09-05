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
