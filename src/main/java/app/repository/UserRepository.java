package app.repository;

import app.model.User;

import java.util.List;


public interface UserRepository {

    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user);

    User findUserById(long id);

    User deleteUser(long id);
}
