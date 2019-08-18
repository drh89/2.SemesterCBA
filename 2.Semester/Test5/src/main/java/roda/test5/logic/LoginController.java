package roda.test5.logic;

import roda.test5.data.User;
import roda.test5.data.UserDAO;

public class LoginController {

    public boolean isValid(String username, String password){
        if(username == null || username.isEmpty()) return false;
        if(password == null || password.isEmpty()) return false;
        User user = new UserDAO().getUser(username);
        return password.equals(user.getPassword());
    }

    public User getUser(String username) {
        return new UserDAO().getUser(username);
    }
}
