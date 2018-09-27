package com.andretadeu.demoapp.persistence;

import com.andretadeu.demoapp.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Stateless
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    public List<User> list() {
        TypedQuery<User> query = em.createQuery(
                "select u from User u", User.class);
        return query.getResultList();
    }

    public void add(final User user) {
        Objects.requireNonNull(user, "User must not be null!");
        em.persist(user);
    }
}
