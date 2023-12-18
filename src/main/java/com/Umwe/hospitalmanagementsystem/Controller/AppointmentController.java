package com.Umwe.hospitalmanagementsystem.Controller;

import com.Umwe.hospitalmanagementsystem.Model.Appointment;
import com.Umwe.hospitalmanagementsystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AppointmentController {

    @Autowired
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Create
    @PostMapping(value = "/saveAppointment")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        if (appointment != null) {
            Appointment createdAppointment = appointmentService.saveAppointment(appointment);
            if (createdAppointment != null) {
                return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Read
    @GetMapping(value = "/listAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/listAppointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
        Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping(value = "/updateAppointments/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable String id, @RequestBody Appointment updatedAppointment) {
        Appointment appointment = appointmentService.updateAppointment(id, updatedAppointment);
        if (appointment != null) {
            return new ResponseEntity<>("Appointment updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Appointment not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping(value = "/deleteAppointments/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable String id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Appointment deleted successfully", HttpStatus.NO_CONTENT);
    }
}
