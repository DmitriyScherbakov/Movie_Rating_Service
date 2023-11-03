package com.example.movie_rating_service.model;

import com.example.movie_rating_service.model.enums.Role;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application_users", schema = "mrsdb")
public class ApplicationUser {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 15, message = "Login должен быть размером от 3 до 15 символов")
    @Column(name = "login", unique = true, nullable = false, length = 15)
    private String login;

    @Size(min = 3, max = 15, message = "Password должен быть размером от 3 до 15 символов")
    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Event> events;

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
