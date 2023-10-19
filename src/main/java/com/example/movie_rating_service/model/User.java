package com.example.movie_rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@EqualsAndHashCode(exclude = "films")
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true, nullable = false, length = 45)
    private String email;

    @Column(name = "login", unique = true, nullable = false, length = 15)
    private String login;

    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<Grade> grades;

    @ManyToMany
    @JoinTable (name="film_likes",
            joinColumns=@JoinColumn (name="user_id"),
            inverseJoinColumns=@JoinColumn(name="film_id"))
    private List<Film> films;
}
