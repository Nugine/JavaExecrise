package ums;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoForArray();
        Application app = new Application(userDao);
        
        app.registe();
        app.login();
    }
}