package com.Umwe.hospitalmanagementsystem.Repository;


import com.Umwe.hospitalmanagementsystem.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
    @Query("SELECT d.id FROM Department d WHERE SUBSTRING(d.id, 4, 8) = ?1 ORDER BY d.id DESC")
    List<String> findTopByOrderByIdDesc(String datePart);
}

