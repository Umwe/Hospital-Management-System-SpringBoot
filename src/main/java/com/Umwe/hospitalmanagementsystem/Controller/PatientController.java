package com.Umwe.hospitalmanagementsystem.Controller;

import com.Umwe.hospitalmanagementsystem.Model.Patient;
import com.Umwe.hospitalmanagementsystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PatientController {

    @Autowired

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    // Create
    @PostMapping(value = "/savePatient")
    public ResponseEntity<Patient> createPatients(@RequestBody Patient patient) {
        if (patient != null) {
            Patient createdPatient = patientService.savePatient(patient);
            if (createdPatient != null) {
                return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // Read
    @GetMapping(value = "/listPatients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/listPatients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping(value ="/updatePatients/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        Patient patient = patientService.updatePatient(id, updatedPatient);
        if (patient != null) {
            return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Patient not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(value ="/deletepatients/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.NO_CONTENT);
    }
}

