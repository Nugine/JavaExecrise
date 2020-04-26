package restaurant;

import java.util.ArrayList;
import java.util.List;

public class DislikedFoodMenu {
    private List<String> DislikedFood;

    public DislikedFoodMenu() {
        DislikedFood = new ArrayList<String>();
    }

    public void addDislikedFood(String food) {
        for (String df : DislikedFood) {
            if (df.equals(food)) {
                return;
            }
        }
        DislikedFood.add(food);
    }

    public void checkFood(String food) throws BadFoodException {
        for (String df : DislikedFood) {
            if (df.equals(food)) {
                throw new BadFoodException();
            }
        }
    }
}