package com.Umwe.hospitalmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @Column(name = "appointment_id")
    private String id;


    @Column(name = "patient_id")
    private String patientid;

    @Column(name = "first_name")
    @NotNull
    private String firstname;


    @Column(name = "last_name")
    @NotNull
    private String lastname;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "department")
    @NotNull
    private String department;

    @Column(name = "appointment_date")
    @NotNull
    private String date;

    @Column(name = "appointment_time")
    @NotNull
    private String time;

    @Column(name = "note")
    private String note;

    public Appointment() {
    }

    public Appointment(String id, String patientid, String firstname, String lastname, String email, String phoneNumber, String department, String date, String time, String note) {
        this.id = id;
        this.patientid = patientid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.date = date;
        this.time = time;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
