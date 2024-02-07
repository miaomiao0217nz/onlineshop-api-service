package nz.co.onlineshop.api.user;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private long usersId;
    private String usersName;
    private String usersEmail;
    private String usersUname;
    private String usersPwd;

    public User(long usersId, String usersName, String usersEmail, String usersUname, String usersPwd) {
        this.usersId = usersId;
        this.usersName = usersName;
        this.usersEmail = usersEmail;
        this.usersUname = usersUname;
        this.usersPwd = usersPwd;
    }

    public User() {
    }

    public long getUsersId() {
        return usersId;
    }

    public String getUsersName() {
        return usersName;
    }

    public String getUsersEmail() {
        return usersEmail;
    }

    public String getUsersUname() {
        return usersUname;
    }

    public String getUsersPwd() {
        return usersPwd;
    }

    public User withId(long id) {
        return new User(id, usersName, usersEmail, usersUname, usersPwd);
    }
}