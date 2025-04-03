package ru.mironov.spring.SpringBoot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.mironov.spring.SpringBoot.model.User;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = getUser(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setSurname(user.getSurname());
            existingUser.setAge(user.getAge());
            existingUser.setEmail(user.getEmail());
            entityManager.merge(existingUser);
        }
    }

    @Override
    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
