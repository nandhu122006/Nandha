package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Grievance;

@RestController
@RequestMapping("/api/grievances")
public class GrievanceController {

    @PostMapping
    public ResponseEntity<Grievance> createGrievance(
            @RequestBody(required = false) Grievance grievance) {

        if (grievance == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(grievance, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Grievance>> getAllGrievances() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getGrievanceById(@PathVariable Long id) {
        return new ResponseEntity<>("Grievance not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGrievance(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrievance(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
