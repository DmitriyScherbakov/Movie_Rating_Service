package com.example.movie_rating_service.model;

import com.example.movie_rating_service.model.enums.ERole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application_users")
public class ApplicationUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", nullable = false, length = 15)
    private String login;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "role")
    private ERole role = ERole.USER;

    @OneToMany(mappedBy = "user")
    private Set<Event> events;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "user")
    private Set<Grade> grades;

    @ManyToMany
    @JoinTable (name="film_likes",
            joinColumns=@JoinColumn (name="user_id"),
            inverseJoinColumns=@JoinColumn(name="film_id"))
    private Set<Film> films;
}
