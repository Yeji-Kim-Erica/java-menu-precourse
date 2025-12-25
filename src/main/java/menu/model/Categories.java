package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Categories {
    private final List<Menu> categories = new ArrayList<>();

    public Categories() {
        setWeeklyCategories();
    }

    private void setWeeklyCategories() {
        while(categories.size() < 5) {
            int categoryNumber = Randoms.pickNumberInRange(1, 5);
            Menu menu = Menu.getCategory(categoryNumber);
            if (getNumberOfCategories(menu) < 2) {
                categories.add(menu);
            }
        }
    }

    private int getNumberOfCategories(Menu menu) {
        int sum = 0;
        for (Menu category : categories) {
            if (category.equals(menu)) {
                sum++;
            }
        }
        return sum;
    }
}
