package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Menus {
    private final Map<Person, List<String>> matchingWeeklyMenus;

    private Menus(Map<Person, List<String>> matchingWeeklyMenus) {
        this.matchingWeeklyMenus = matchingWeeklyMenus;
    }

    public static Menus of(Persons persons, Categories categories) {
        Map<Person, List<String>> matchingWeeklyMenus = new LinkedHashMap<>();
        for (Person person : persons.getPersons()) {
            List<String> weeklyMenus = getWeeklyMenus(person, categories);
            matchingWeeklyMenus.put(person, weeklyMenus);
        }
        return new Menus(matchingWeeklyMenus);
    }

    private static List<String> getWeeklyMenus(Person person, Categories categories) {
        List<String> weeklyMenus = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<String> menus = categories.getMenus(i);
            String menu = Randoms.shuffle(menus).get(0);
            while (weeklyMenus.contains(menu) || person.containsForbiddenMenus(menu)) {
                menu = Randoms.shuffle(menus).get(0);
            }
            weeklyMenus.add(menu);
        }
        return weeklyMenus;
    }
}
