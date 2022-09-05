package com.bridgelabz.springemployeepayrollappdevelopment_day5.model;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)

    public int id;
    public String name;
    public String profilePic;
    public String gender;
    public int salary;
    public LocalDate startDate;
    public String notes;

    public EmployeePayrollData(int i, EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.gender = employeePayrollDTO.getGender();
        this.salary = employeePayrollDTO.getSalary();

    }

    public EmployeePayrollData(int id, String name, String profilePic, String gender,
                               int salary, LocalDate startDate, String notes) {
        this.id = id;
        this.name = name;
        this.profilePic = profilePic;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
    }

    public EmployeePayrollData() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                '}';
    }
}
