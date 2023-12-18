package com.Umwe.hospitalmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @Column(name = "patient_id")
    private String id;
    @Column(name = "patient_firstname")
    private String firstName;
    @Column(name = "patient_lastname")
    private String lastName;
    @Column(name = "patient_email")
    private String email;
    @Column(name = "patient_phone")
    @NotNull
    private String PhoneNumber;
    @Column(name = "patient_gender")
    @NotNull
    private String Gender;
    @Column(name = "patient_dob")
    private String dob;
    @Column(name = "patient_address")
    private String address;
    @Column(name = "patient_national_id")
    private String idNumber;
    @Column(name = "patient_insurance")
    private String insurance;

    @Column(name = "patient_bloodgroup")
    private String bloodgroup;

    @Column(name = "patient_password")
    private String password;
    @Column(name = "patient_status")
    private String status;

    public Patient() {
    }

    public Patient(String id, String firstName, String lastName, String email, String phoneNumber, String gender, String dob, String address, String idNumber, String insurance, String bloodgroup, String password, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        PhoneNumber = phoneNumber;
        Gender = gender;
        this.dob = dob;
        this.address = address;
        this.idNumber = idNumber;
        this.insurance = insurance;
        this.bloodgroup = bloodgroup;
        this.password = password;
        this.status = status;
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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
