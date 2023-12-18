package com.Umwe.hospitalmanagementsystem.Service;

import com.Umwe.hospitalmanagementsystem.Model.Patient;
import com.Umwe.hospitalmanagementsystem.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private final PatientRepo patientRepository;

    public PatientService(PatientRepo patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Create
    public Patient savePatient(Patient patient) {
        try {
            // Generate the custom ID
            patient.setId(generatePatientId());

            // Save the patient
            Patient savedPatient = patientRepository.save(patient);
            System.out.println("Patient saved successfully: " + savedPatient);
            return savedPatient;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving patient: " + e.getMessage());
            return null;
        }
    }

    // Read
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    // Update
    public Patient updatePatient(String id, Patient updatedPatient) {
        if (patientRepository.existsById(id)) {
            updatedPatient.setId(id);
            return patientRepository.save(updatedPatient);
        } else {
            // Handle the case when the patient with the given id does not exist
            return null;
        }
    }

    // Delete
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }

    // Custom method to generate the patient ID
    private String generatePatientId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String datePart = dateFormat.format(new Date());

        // Retrieve the last generated patient ID for the current date
        List<String> lastPatientIds = patientRepository.findTopByOrderByIdDesc(datePart);

        // If there is no existing patient ID for the current date, start with 1
        if (lastPatientIds.isEmpty()) {
            return "PTR" + datePart + "UMWE001";
        }

        // Extract the numeric part and increment by 1
        String lastPatientId = lastPatientIds.get(0);
        String numericPart = lastPatientId.substring(11 + "UMWE".length()); // Adjust for the length of "UMWE"
        int sequenceNumber = Integer.parseInt(numericPart) + 1;

        // Format the sequence number with leading zeros
        String formattedSequence = String.format("%03d", sequenceNumber);

        // Construct the final patient ID
        return "PTR" + datePart + "UMWE" + formattedSequence;
    }




}
