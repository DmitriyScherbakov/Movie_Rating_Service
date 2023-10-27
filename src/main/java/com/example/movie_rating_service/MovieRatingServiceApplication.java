package com.example.movie_rating_service;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MovieRatingServiceApplication {

    public static void main(String[] args) {
        System.out.println("Hello World!!!!!!!!!!!!");

        SpringApplication.run(MovieRatingServiceApplication.class, args);

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.close();

    }

}
