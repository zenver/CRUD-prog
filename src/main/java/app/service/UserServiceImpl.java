package app.service;

import app.model.User;
import app.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void createOrUpdateUser(User user) {
        if (0 == user.getId()) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }

    private void createUser(User user) {
        userRepository.createUser(user);
    }

    private void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public User readUser(long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userRepository.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }

}
