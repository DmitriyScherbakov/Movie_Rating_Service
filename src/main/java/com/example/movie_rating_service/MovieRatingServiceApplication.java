package com.example.movie_rating_service;


import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRatingServiceApplication.class, args);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }

}
