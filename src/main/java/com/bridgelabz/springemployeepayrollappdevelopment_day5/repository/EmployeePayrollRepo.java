package com.bridgelabz.springemployeepayrollappdevelopment_day5.repository;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepo extends JpaRepository<EmployeePayrollData, Integer> {

}
