package ums;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoForArray();
        Application app = new Application(userDao);

        Scanner sc = new Scanner(System.in);
        for (boolean flag = true; flag;) {
            System.out.println("******用户管理系统测试界面******");
            String cmd = sc.nextLine();
            switch (cmd) {
                case "exit":
                    System.out.println("退出测试界面");
                    flag = false;
                    break;
                case "registe": // shoule be "register"
                    app.registe();
                    break;
                case "login":
                    app.login();
                    break;
            }
        }
        sc.close();

    }
}