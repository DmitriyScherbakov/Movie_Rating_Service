package com.example.movie_rating_service.service;


import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.repositories.GradeRepository;
import com.example.movie_rating_service.service.serviceInterfaces.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getGradeById(long id) {
        Optional<Grade> foundGrade = gradeRepository.findById(id);
        return foundGrade.orElse(null);
    }

    @Transactional
    @Override
    public void createGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Transactional
    @Override
    public void updateGrade(Long id, Grade updatedGrade) {
        updatedGrade.setGradeId(id);
        gradeRepository.save(updatedGrade);
    }

    @Transactional
    @Override
    public void deleteGradeById(long id) {
        gradeRepository.deleteById(id);
    }
}
