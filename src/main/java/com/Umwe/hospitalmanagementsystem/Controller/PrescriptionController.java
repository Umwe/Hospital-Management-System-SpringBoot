package com.Umwe.hospitalmanagementsystem.Controller;

import com.Umwe.hospitalmanagementsystem.Model.Prescription;
import com.Umwe.hospitalmanagementsystem.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/prescriptions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    // Create
    @PostMapping(value = "/savePrescription")
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        if (prescription != null) {
            Prescription createdPrescription = prescriptionService.savePrescription(prescription);
            if (createdPrescription != null) {
                return new ResponseEntity<>(createdPrescription, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Read
    @GetMapping(value = "/listPrescriptions")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @GetMapping("/listPrescriptions/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable String id) {
        Optional<Prescription> prescription = prescriptionService.getPrescriptionById(id);
        return prescription.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping(value ="/updatePrescription/{id}")
    public ResponseEntity<String> updatePrescription(@PathVariable String id, @RequestBody Prescription updatedPrescription) {
        Prescription prescription = prescriptionService.updatePrescription(id, updatedPrescription);
        if (prescription != null) {
            return new ResponseEntity<>("Prescription updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Prescription not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(value ="/deletePrescription/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable String id) {
        prescriptionService.deletePrescription(id);
        return new ResponseEntity<>("Prescription deleted successfully", HttpStatus.NO_CONTENT);
    }
}
