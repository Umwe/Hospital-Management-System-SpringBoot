package com.Umwe.hospitalmanagementsystem.Model;



import jakarta.persistence.*;


@Entity
@Table(name="prescription")
public class Prescription {

    @Id
    @Column(name = "prescription_id")
    private String id;

    @Column(name = "doctor_id")
    private String doctor_id;

    @Column(name = "doctor_name")
    private String doctor_name;

    @Column(name = "patient_id")
    private String patient_id;

    @Column(name = "patient_name")
    private String patient_name;

    @Column(name = "date")
    private String date;

    @Column(name = "consultation_details")
    private String consultation_details;

    public Prescription() {
    }

    public Prescription(String id, String doctor_id, String doctor_name, String patient_id, String patient_name, String date, String consultation_details) {
        this.id = id;
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.date = date;
        this.consultation_details = consultation_details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConsultation_details() {
        return consultation_details;
    }

    public void setConsultation_details(String consultation_details) {
        this.consultation_details = consultation_details;
    }
}