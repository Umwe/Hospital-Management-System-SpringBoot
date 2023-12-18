package com.Umwe.hospitalmanagementsystem.Repository;

import com.Umwe.hospitalmanagementsystem.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, String> {
    @Query("SELECT a.id FROM Appointment a WHERE SUBSTRING(a.id, 4, 8) = ?1 ORDER BY a.id DESC")
    List<String> findTopByOrderByIdDesc(String datePart);
}
