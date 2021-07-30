package hiber.services;

import hiber.entities.User;

import java.util.List;

public interface UserService {
    public User getUser();
    public List<User> getAllUsers();
    public void saveUser(User user);
}
