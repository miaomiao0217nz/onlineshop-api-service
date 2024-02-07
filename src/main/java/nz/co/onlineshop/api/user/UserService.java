package nz.co.onlineshop.api.user;

import nz.co.onlineshop.api.user.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        User u = userRepository.findByUsersUname(user.getUsersUname());
        if (nonNull(u))
            user = user.withId(u.getUsersId());
        return userRepository.save(user);
    }

    public User findUser(String userName) {
        return userRepository.findByUsersUname(userName);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsersUname(username);
        if (user != null && user.getUsersPwd().equals(password)) {
            return true;
        }
        return false;
    }

}
