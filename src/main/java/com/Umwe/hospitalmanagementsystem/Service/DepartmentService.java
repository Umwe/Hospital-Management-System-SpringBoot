package com.Umwe.hospitalmanagementsystem.Service;

import com.Umwe.hospitalmanagementsystem.Model.Department;
import com.Umwe.hospitalmanagementsystem.Repository.DepartmentRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @PersistenceContext
    private EntityManager entityManager;

    // Create
    @Transactional
    public Department saveDepartment(Department department) {
        try {
            // Generate and set the department ID
            String generatedDepartmentId = generateDepartmentId();
            department.setId(generatedDepartmentId);

            Department savedDepartment = departmentRepo.save(department);
            System.out.println("Department saved successfully: " + savedDepartment);
            return savedDepartment;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error saving department: " + e.getMessage());
            return null;
        }
    }

    // Read
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    public Optional<Department> getDepartmentById(String id) {
        return departmentRepo.findById(id);
    }

    // Update
    public Department updateDepartment(String id, Department updatedDepartment) {
        if (departmentRepo.existsById(id)) {
            updatedDepartment.setId(id);
            return departmentRepo.save(updatedDepartment);
        } else {
            // Handle the case when the department with the given id does not exist
            return null;
        }
    }

    // Delete
    public void deleteDepartment(String id) {
        departmentRepo.deleteById(id);
    }

    // Generate department ID
    private String generateDepartmentId() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String datePart = dateFormat.format(new Date());

        // Retrieve the last generated department ID for the current date
        Query query = entityManager.createQuery("SELECT d.id FROM Department d WHERE SUBSTRING(d.id, 4, 8) = :datePart ORDER BY d.id DESC");
        query.setParameter("datePart", datePart);
        List<String> lastDepartmentIds = query.getResultList();

        // If there is no existing department ID for the current date, start with 1
        if (lastDepartmentIds.isEmpty()) {
            return "DPT" + datePart + "UMWE001";
        }

        // Extract the numeric part and increment by 1
        String lastDepartmentId = lastDepartmentIds.get(0);
        String numericPart = lastDepartmentId.substring(11 + "UMWE".length()); // Adjust for the length of "UMWE"
        int sequenceNumber = Integer.parseInt(numericPart) + 1;

        // Format the sequence number with leading zeros
        String formattedSequence = String.format("%03d", sequenceNumber);

        // Construct the final department ID
        return "DPT" + datePart + "UMWE" + formattedSequence;
    }
}
