package com.example.movie_rating_service.service.serviceInterfaces;

import com.example.movie_rating_service.model.Grade;
import com.example.movie_rating_service.model.User;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrades();

    Grade getGradeById(long id);

    void createGrade(Grade grade);

    void updateGrade(Long id, Grade grade);

    void deleteGradeById(long id);
}
