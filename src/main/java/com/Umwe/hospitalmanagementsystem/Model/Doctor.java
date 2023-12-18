package com.Umwe.hospitalmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    private String id;
    @NotNull
    @Column(name = "doctor_firstName")
    private String firstName;
    @NotNull
    @Column(name = "doctor_lastname")
    private String lastName;

    @NotNull
    @Column(name = "doctor_email")
    private String email;
    @NotNull
    @Column(name = "licence_number")
    private String licence;
    @NotNull
    @Column(name = "doctor_specialization")
    private String specialization;

    @Column(name = "doctor_gender")
    @NotNull
    private String Gender;

    @Column(name = "doctor_phone")
    @NotNull
    private String PhoneNumber;

    @Column(name = "department")
    @NotNull
    private String department;

    @NotNull
    @Column(name = "password")
    private String password;

    public Doctor() {
    }

    public Doctor(String id, String firstName, String lastName, String email, String licence, String specialization, String gender, String phoneNumber, String department, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.licence = licence;
        this.specialization = specialization;
        Gender = gender;
        PhoneNumber = phoneNumber;
        this.department = department;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}