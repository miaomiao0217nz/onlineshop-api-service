package nz.co.onlineshop.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/api/user")
    public List<User> findUsers() {
        return userService.findUsers();
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean isValidUser = userService.validateUser(user.getUsersUname(), user.getUsersPwd());
        if (isValidUser) {

            return ResponseEntity.ok().body(buildResponse(true));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    private Map<String,Object> buildResponse(boolean result){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("success", result);
        return resultMap;
    }

}