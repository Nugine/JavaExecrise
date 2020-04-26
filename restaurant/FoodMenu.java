package restaurant;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<String> menu;

    public FoodMenu() {
        menu = new ArrayList<String>();
    }

    public void addFood(String food) {
        for (String f : menu) {
            if (f.equals(food)) {
                return;
            }
        }
        menu.add(food);
    }

    public String getFoodByNo(int no) {
        return menu.get(no - 1);
    }

    public int getFoodNumbers() {
        return menu.size();
    }

    public void showMenu() {
        System.out.println("******菜单******");

        int len = menu.size();
        for (int i = 0; i < len; ++i) {
            System.out.printf("%d. %s\n", i + 1, menu.get(i));
        }
    }
}