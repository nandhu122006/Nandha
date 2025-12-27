package com.examly.springapp.service;

import com.examly.springapp.model.GrievanceCategory;
import java.util.List;

public interface GrievanceCategoryService {
    GrievanceCategory addGrievanceCategory(GrievanceCategory grievanceCategory);
    List<GrievanceCategory> getAllGrievanceCategories();
    GrievanceCategory getGrievanceCategoryById(Long id);
    GrievanceCategory updateGrievanceCategory(Long id, GrievanceCategory grievanceCategory);
    void deleteGrievanceCategory(Long id);
    List<GrievanceCategory> searchGrievanceCategories(String keyword);
}