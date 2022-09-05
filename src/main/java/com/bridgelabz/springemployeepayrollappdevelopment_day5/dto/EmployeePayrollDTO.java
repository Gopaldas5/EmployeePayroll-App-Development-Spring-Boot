package com.bridgelabz.springemployeepayrollappdevelopment_day5.dto;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not a valid Name : It should at least 3 characters  ")
    public String name;
    public String gender;
    public int salary;

}
