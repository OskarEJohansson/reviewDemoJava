package org.example.models;

public class User {

    private String userName;
    private String email;
    private String password;

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String setUserName) {
        this.userName = setUserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String setEmail) {
        this.email = setEmail;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
