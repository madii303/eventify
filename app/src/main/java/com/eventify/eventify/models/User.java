package com.eventify.eventify.models;

public class User {
    public int User_id;
    public String Username;
    public String Password;
    public String Contact_no;
    public String Contact_email;
    public String User_type;


    public User(String username, String password, String contact_no, String contact_email, String user_type) {
        Username = username;
        Password = password;
        Contact_no = contact_no;
        Contact_email = contact_email;
        User_type = user_type;
    }

    public User() {

    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public String getContact_email() {
        return Contact_email;
    }

    public void setContact_email(String contact_email) {
        Contact_email = contact_email;
    }

    public String getUser_type() {
        return User_type;
    }

    public void setUser_type(String user_type) {
        User_type = user_type;
    }
}
