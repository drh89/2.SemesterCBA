package roda.logic;

import roda.data.User;
import roda.data.UserDAO;

public class Controller {
    
    public boolean checkPassword(String username, String password){
        User user = new UserDAO().getUser(username);
        if(password == null) return false;
        return password.equals(user.getPassword());
    }
}
