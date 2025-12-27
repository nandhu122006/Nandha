package com.examly.springapp.service;

import com.examly.springapp.model.Grievance;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class GrievanceServiceImpl implements GrievanceService {

    @Override
    public Grievance addGrievance(Grievance grievance) {
        return grievance;
    }

    @Override
    public List<Grievance> getAllGrievances() {
        return new ArrayList<>();
    }

    @Override
    public Grievance getGrievanceById(Long id) {
        return new Grievance();
    }

    @Override
    public Grievance updateGrievance(Long id, Grievance grievance) {
        return grievance;
    }

    @Override
    public void deleteGrievance(Long id) {
    }
}