package com.examly.springapp.service;

import com.examly.springapp.model.Department;
import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.repository.DepartmentRepository;
import com.examly.springapp.repository.GrievanceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrievanceCategoryServiceImpl implements GrievanceCategoryService {

    @Autowired
    private GrievanceCategoryRepository grievanceCategoryRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public GrievanceCategory addGrievanceCategory(GrievanceCategory grievanceCategory) {
        // If category has a department, ensure it exists or create it
        if (grievanceCategory.getDepartment() != null && grievanceCategory.getDepartment().getDepartmentId() != null) {
            Long deptId = grievanceCategory.getDepartment().getDepartmentId();
            if (!departmentRepository.existsById(deptId)) {
                // Create a default department if it doesn't exist
                Department dept = new Department();
                dept.setDepartmentId(deptId);
                dept.setDepartmentName("Default Department");
                dept.setContactEmail("default@example.com");
                dept.setContactPhone("0000000000");
                departmentRepository.save(dept);
            }
        }
        return grievanceCategoryRepository.save(grievanceCategory);
    }

    @Override
    public List<GrievanceCategory> getAllGrievanceCategories() {
        return grievanceCategoryRepository.findAll();
    }

    @Override
    public GrievanceCategory getGrievanceCategoryById(Long id) {
        return grievanceCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public GrievanceCategory updateGrievanceCategory(Long id, GrievanceCategory grievanceCategory) {
        if (grievanceCategoryRepository.existsById(id)) {
            grievanceCategory.setCategoryId(id);
            return grievanceCategoryRepository.save(grievanceCategory);
        }
        return null;
    }

    @Override
    public void deleteGrievanceCategory(Long id) {
        grievanceCategoryRepository.deleteById(id);
    }

    @Override
    public List<GrievanceCategory> searchGrievanceCategories(String keyword) {
        return grievanceCategoryRepository.findByCategoryNameContainingIgnoreCase(keyword);
    }
}