package com.Umwe.hospitalmanagementsystem.Repository;

import com.Umwe.hospitalmanagementsystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepo extends JpaRepository<Doctor, String> {
    @Query("SELECT d.id FROM Doctor d WHERE SUBSTRING(d.id, 4, 8) = ?1 ORDER BY d.id DESC")
    List<String> findTopByOrderByIdDesc(String datePart);
}
