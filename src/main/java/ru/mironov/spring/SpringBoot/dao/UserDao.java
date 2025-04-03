package ru.mironov.spring.SpringBoot.dao;

import ru.mironov.spring.SpringBoot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void updateUser(User user);

    public void deleteUser(int id);
}
