package com.Umwe.hospitalmanagementsystem.Controller;

import com.Umwe.hospitalmanagementsystem.Model.Doctor;
import com.Umwe.hospitalmanagementsystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/doctors", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Create
    @PostMapping(value = "/saveDoctor")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        if (doctor != null) {
            Doctor createdDoctor = doctorService.saveDoctor(doctor);
            if (createdDoctor != null) {
                return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Read
    @GetMapping(value = "/listDoctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/listDoctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        Optional<Doctor> doctor = doctorService.getDoctorById(id);
        return doctor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping(value ="/updateDoctors/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable String id, @RequestBody Doctor updatedDoctor) {
        Doctor doctor = doctorService.updateDoctor(id, updatedDoctor);
        if (doctor != null) {
            return new ResponseEntity<>("Doctor updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Doctor not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(value ="/deleteDoctors/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Doctor deleted successfully", HttpStatus.NO_CONTENT);
    }
}
