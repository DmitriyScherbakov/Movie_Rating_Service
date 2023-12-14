package com.example.movie_rating_service.service;


import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.model.Review;
import com.example.movie_rating_service.repositories.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Grade getGradeById(long id) {
        Optional<Grade> foundGrade = gradeRepository.findById(id);
        return foundGrade.orElse(null);
    }

    @Transactional
    public void createGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Transactional
    public void updateGrade(Long id, Grade updatedGrade) {
        updatedGrade.setGradeId(id);
        gradeRepository.save(updatedGrade);
    }

    @Transactional
    public void deleteGradeById(long id) {
        gradeRepository.deleteById(id);
    }

    public boolean hasUserAlreadyRatedFilm(long userId, long filmId) {
        return gradeRepository.existsByUserIdAndFilmFilmId(userId, filmId);
    }

    public List<Grade> getGradesByUserId(long id){
        return gradeRepository.findGradesByUserId(id);
    }
}
