package com.example.movie_rating_service;

import com.example.movie_rating_service.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRatingServiceApplication {

    public static void main(String[] args) {
        System.out.println("Hello World!!!!!!!!!!!!");

        SpringApplication.run(MovieRatingServiceApplication.class, args);


        /*User user = new User();
        user.setEmail("user1@example.com");
        user.setLogin("username1");
        user.setPassword("password1");*/

        Session session = HibernateUtil.getSessionFactory().openSession();
        //Transaction transaction = session.beginTransaction();

        //session.save(user);

        //transaction.commit();
        session.close();

    }

}
