package roda.test5.data;

public class UserDAO {

    public User getUser(String username){
        return new User(username, "1234");
    }
}
