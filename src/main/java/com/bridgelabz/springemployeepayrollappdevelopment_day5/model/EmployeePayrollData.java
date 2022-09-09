package com.bridgelabz.springemployeepayrollappdevelopment_day5.model;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    public int id;
    public String firstName;
    public String lastName;
    public String profilePic;
    public String gender;
    public int salary;
    public LocalDate startDate;
    public String notes;

    @ElementCollection
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "employee_id"))
    public List<String> departments;

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.firstName = employeePayrollDTO.getFirstName();
        this.lastName = employeePayrollDTO.getLastname();
        this.gender = employeePayrollDTO.getGender();
        this.salary = employeePayrollDTO.getSalary();
        this.departments = employeePayrollDTO.getDepartments();

    }
    public EmployeePayrollData() {

    }

    public EmployeePayrollData(int id, String firstName, String lastName, String profilePic, String gender,
                               int salary, LocalDate startDate, String notes, List<String> departments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.gender = gender;
        this.salary = salary;
        this.startDate = startDate;
        this.notes = notes;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", notes='" + notes + '\'' +
                ", departments=" + departments +
                '}';
    }
}
