package ru.mironov.spring.SpringBoot.service;

import ru.mironov.spring.SpringBoot.users.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void updateUser(User user);

    public void deleteUser(int id);
}
