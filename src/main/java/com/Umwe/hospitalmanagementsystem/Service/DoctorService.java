package com.Umwe.hospitalmanagementsystem.Service;

import com.Umwe.hospitalmanagementsystem.Model.Doctor;
import com.Umwe.hospitalmanagementsystem.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepo doctorRepo;

    @Autowired
    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    // Create
    public Doctor saveDoctor(Doctor doctor) {
        try {
            // Generate the custom ID
            doctor.setId(generateDoctorId());

            // You can add any custom logic or validation here before saving the doctor

            // Save the doctor
            Doctor savedDoctor = doctorRepo.save(doctor);
            System.out.println("Doctor saved successfully: " + savedDoctor);
            return savedDoctor;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving doctor: " + e.getMessage());
            return null;
        }
    }

    // Read
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Optional<Doctor> getDoctorById(String id) {
        return doctorRepo.findById(id);
    }

    // Update
    public Doctor updateDoctor(String id, Doctor updatedDoctor) {
        if (doctorRepo.existsById(id)) {
            updatedDoctor.setId(id);
            return doctorRepo.save(updatedDoctor);
        } else {
            // Handle the case when the doctor with the given id does not exist
            return null;
        }
    }

    // Delete
    public void deleteDoctor(String id) {
        doctorRepo.deleteById(id);
    }

    // Custom method to generate the doctor ID
    private String generateDoctorId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String datePart = dateFormat.format(new Date());

        // Retrieve the last generated doctor ID for the current date
        List<String> lastDoctorIds = doctorRepo.findTopByOrderByIdDesc(datePart);

        // If there is no existing doctor ID for the current date, start with 1
        if (lastDoctorIds.isEmpty()) {
            return "DOC" + datePart + "UMWE001";
        }

        // Extract the numeric part and increment by 1
        String lastDoctorId = lastDoctorIds.get(0);
        String numericPart = lastDoctorId.substring(11 + "UMWE".length()); // Adjust for the length of "UMWE"
        int sequenceNumber = Integer.parseInt(numericPart) + 1;

        // Format the sequence number with leading zeros
        String formattedSequence = String.format("%03d", sequenceNumber);

        // Construct the final doctor ID
        return "DOC" + datePart + "UMWE" + formattedSequence;
    }
}
