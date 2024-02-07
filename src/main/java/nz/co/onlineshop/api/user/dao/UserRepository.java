package nz.co.onlineshop.api.user.dao;

import nz.co.onlineshop.api.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods

    User findByUsersUname(String usersUname);
}