package com.Umwe.hospitalmanagementsystem.Service;

import com.Umwe.hospitalmanagementsystem.Model.Appointment;
import com.Umwe.hospitalmanagementsystem.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private final AppointmentRepo appointmentRepository;

    public AppointmentService(AppointmentRepo appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Create
    public Appointment saveAppointment(Appointment appointment) {
        try {
            // Generate the custom ID
            appointment.setId(generateAppointmentId());

            // Save the appointment
            Appointment savedAppointment = appointmentRepository.save(appointment);
            System.out.println("Appointment saved successfully: " + savedAppointment);
            return savedAppointment;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving appointment: " + e.getMessage());
            return null;
        }
    }

    // Read
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(String id) {
        return appointmentRepository.findById(id);
    }

    // Update
    public Appointment updateAppointment(String id, Appointment updatedAppointment) {
        if (appointmentRepository.existsById(id)) {
            updatedAppointment.setId(id);
            return appointmentRepository.save(updatedAppointment);
        } else {
            // Handle the case when the appointment with the given id does not exist
            return null;
        }
    }

    // Delete
    public void deleteAppointment(String id) {
        appointmentRepository.deleteById(id);
    }

    // Custom method to generate the appointment ID
    private String generateAppointmentId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String datePart = dateFormat.format(new Date());

        // Retrieve the last generated appointment ID for the current date
        List<String> lastAppointmentIds = appointmentRepository.findTopByOrderByIdDesc(datePart);

        // If there is no existing appointment ID for the current date, start with 1
        if (lastAppointmentIds.isEmpty()) {
            return "APT" + datePart + "UMWE001";
        }

        // Extract the numeric part and increment by 1
        String lastAppointmentId = lastAppointmentIds.get(0);
        String numericPart = lastAppointmentId.substring(11 + "UMWE".length()); // Adjust for the length of "UMWE"
        int sequenceNumber = Integer.parseInt(numericPart) + 1;

        // Format the sequence number with leading zeros
        String formattedSequence = String.format("%03d", sequenceNumber);

        // Construct the final appointment ID
        return "APT" + datePart + "UMWE" + formattedSequence;
    }
}
