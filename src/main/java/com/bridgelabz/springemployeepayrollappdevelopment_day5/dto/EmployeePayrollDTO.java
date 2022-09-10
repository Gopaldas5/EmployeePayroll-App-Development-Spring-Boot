package com.bridgelabz.springemployeepayrollappdevelopment_day5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,25}$", message = "Not a valid Name : It should at least 3 characters  ")
    public String firstName;
    public String lastname;
    public String email;
    public String gender;
    public int salary;
    public List<String> departments;

}
