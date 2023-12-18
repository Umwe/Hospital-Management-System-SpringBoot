package com.Umwe.hospitalmanagementsystem.Repository;

import com.Umwe.hospitalmanagementsystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, String> {
    @Query("SELECT p.id FROM Patient p WHERE SUBSTRING(p.id, 4, 8) = ?1 ORDER BY p.id DESC")
    List<String> findTopByOrderByIdDesc(String datePart);
}

