package com.example.movie_rating_service.DAO;

import com.example.movie_rating_service.DAO.DAOInterfaces.UserDAO;
import com.example.movie_rating_service.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List getAllUsers() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class, id);
    }

    @Override
    public void createUser(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(user);
    }

    @Override
    public void deleteUserById(long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
    }

}
