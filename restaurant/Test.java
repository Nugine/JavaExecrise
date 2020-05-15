package restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        FoodMenu menu = new FoodMenu();
        menu.addFood("麻辣香锅");
        menu.addFood("排骨炖豆角");
        menu.addFood("葱爆羊肉");
        menu.addFood("酸辣土豆丝");
        menu.addFood("清炒菜花");
        menu.addFood("清炒芥蓝");

        menu.showMenu();

        DislikedFoodMenu dislikedFoodMenu = new DislikedFoodMenu();
        dislikedFoodMenu.addDislikedFood("葱爆羊肉");

        List<String> ordered = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.print("请为大家点菜，输入编号即可 (0表示点菜结束): ");
            int no = sc.nextInt();
            if (no == 0) {
                sc.close(); // make control flow checker happy
                break;
            }

            String food = menu.getFoodByNo(no);
            try {
                dislikedFoodMenu.checkFood(food);
            } catch (BadFoodException e) {
                System.out.printf("有人不喜欢该菜品...\n", food);
                continue;
            }
            ordered.add(food);

            System.out.println("您已点的菜品如下：");
            for (int i = 0; i < ordered.size(); ++i) {
                System.out.printf("%d. %s\n", i + 1, ordered.get(i));
            }
        }

    }
}