package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Menus {
    private final Categories categories;
    private final Map<Person, List<String>> matchingWeeklyMenus;

    private Menus(Categories categories, Map<Person, List<String>> matchingWeeklyMenus) {
        this.categories = categories;
        this.matchingWeeklyMenus = matchingWeeklyMenus;
    }

    public static Menus of(Persons persons, Categories categories) {
        Map<Person, List<String>> matchingWeeklyMenus = new LinkedHashMap<>();
        for (Person person : persons.getPersons()) {
            List<String> weeklyMenus = getWeeklyMenus(person, categories);
            matchingWeeklyMenus.put(person, weeklyMenus);
        }
        return new Menus(categories, matchingWeeklyMenus);
    }

    public Categories getCategories() {
        return categories;
    }

    public Map<Person, List<String>> getMatchingWeeklyMenus() {
        return Collections.unmodifiableMap(matchingWeeklyMenus);
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
