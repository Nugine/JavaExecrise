package ums.entity;

import java.util.ArrayList;

public class User {
    private String email;
    private String userName;
    private String sex;
    private ArrayList<String> hobbies;

    public User(final String email, final String userName, final String sex, final ArrayList<String> hobbies) {
        this.email = email;
        this.userName = userName;
        this.sex = sex;
        this.hobbies = hobbies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(final String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(final ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

}
