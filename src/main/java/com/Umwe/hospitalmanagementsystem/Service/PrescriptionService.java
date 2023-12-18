package com.Umwe.hospitalmanagementsystem.Service;

import com.Umwe.hospitalmanagementsystem.Model.Prescription;
import com.Umwe.hospitalmanagementsystem.Repository.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;

    @Autowired
    public PrescriptionService(PrescriptionRepo prescriptionRepo) {
        this.prescriptionRepo = prescriptionRepo;
    }

    // Create
    public Prescription savePrescription(Prescription prescription) {
        try {
            // Generate the custom ID
            prescription.setId(generatePrescriptionId());

            // Save the prescription
            Prescription savedPrescription = prescriptionRepo.save(prescription);
            System.out.println("Prescription saved successfully: " + savedPrescription);
            return savedPrescription;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving prescription: " + e.getMessage());
            return null;
        }
    }

    // Read
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepo.findAll();
    }

    public Optional<Prescription> getPrescriptionById(String id) {
        return prescriptionRepo.findById(id);
    }

    // Update
    public Prescription updatePrescription(String id, Prescription updatedPrescription) {
        if (prescriptionRepo.existsById(id)) {
            updatedPrescription.setId(id);
            return prescriptionRepo.save(updatedPrescription);
        } else {
            // Handle the case when the prescription with the given id does not exist
            return null;
        }
    }

    // Delete
    public void deletePrescription(String id) {
        prescriptionRepo.deleteById(id);
    }

    // Custom method to generate the prescription ID
    private String generatePrescriptionId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String datePart = dateFormat.format(new Date());

        // Retrieve the last generated prescription ID for the current date
        List<Prescription> lastPrescriptions = prescriptionRepo.findTopByDateOrderByDateDesc(datePart);

        // If there is no existing prescription for the current date, start with 1
        if (lastPrescriptions.isEmpty()) {
            return "PRX" + datePart + "UMWE001";
        }

        // Extract the numeric part and increment by 1
        String lastPrescriptionId = lastPrescriptions.get(0).getId();
        String numericPart = lastPrescriptionId.substring(11 + "UMWE".length()); // Adjust for the length of "UMWE"
        int sequenceNumber = Integer.parseInt(numericPart) + 1;

        // Format the sequence number with leading zeros
        String formattedSequence = String.format("%03d", sequenceNumber);

        // Construct the final prescription ID
        return "PRX" + datePart + "UMWE" + formattedSequence;
    }
}
