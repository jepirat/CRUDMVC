package DAO;

import entities.User;

import java.util.List;

public interface UserDAO {
    public User getUser();
    public List<User> getAllUsers();
    public void saveUser(User user);
}
