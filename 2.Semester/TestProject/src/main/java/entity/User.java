package entity;

import java.io.Serializable;

public class User implements Serializable
{
    private int id;
    private String userName;
    private String password;
    private boolean admin;

    public User(String userName, String password, boolean admin)
    {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }

    public User(int id, String userName, String password, boolean admin)
    {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isAdmin()
    {
        return admin;
    }

    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }

    @Override
    public String toString()
    {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", admin=" + admin + '}';
    }
}
