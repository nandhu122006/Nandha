package com.examly.springapp.controller;

import com.examly.springapp.model.GrievanceCategory;
import com.examly.springapp.service.GrievanceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grievance-categories")
public class GrievanceCategoryController {
    
    @Autowired
    private GrievanceCategoryService grievanceCategoryService;
    
    @PostMapping
    public ResponseEntity<GrievanceCategory> addGrievanceCategory(@RequestBody GrievanceCategory grievanceCategory) {
        GrievanceCategory savedCategory = grievanceCategoryService.addGrievanceCategory(grievanceCategory);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<GrievanceCategory>> getAllGrievanceCategories() {
        List<GrievanceCategory> categories = grievanceCategoryService.getAllGrievanceCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<GrievanceCategory>> searchGrievanceCategories(@PathVariable String keyword) {
        List<GrievanceCategory> categories = grievanceCategoryService.searchGrievanceCategories(keyword);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GrievanceCategory> getGrievanceCategoryById(@PathVariable Long id) {
        GrievanceCategory category = grievanceCategoryService.getGrievanceCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<GrievanceCategory> updateGrievanceCategory(@PathVariable Long id, @RequestBody GrievanceCategory grievanceCategory) {
        GrievanceCategory updatedCategory = grievanceCategoryService.updateGrievanceCategory(id, grievanceCategory);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrievanceCategory(@PathVariable Long id) {
        grievanceCategoryService.deleteGrievanceCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
