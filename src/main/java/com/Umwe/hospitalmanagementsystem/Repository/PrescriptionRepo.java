package com.Umwe.hospitalmanagementsystem.Repository;

import com.Umwe.hospitalmanagementsystem.Model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescriptionRepo extends JpaRepository<Prescription, String> {
    List<Prescription> findTopByDateOrderByDateDesc(String datePart);
}
