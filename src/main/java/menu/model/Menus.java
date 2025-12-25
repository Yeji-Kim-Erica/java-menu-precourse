package menu.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.Map.Entry;

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
            matchingWeeklyMenus.put(person, new ArrayList<>());
        }

        for (int i = 0; i < 5; i++) {
            Menu category = categories.getCategory(i);
            for (Entry<Person, List<String>> entry : matchingWeeklyMenus.entrySet()) {
                Person person = entry.getKey();
                List<String> weeklyMenus = entry.getValue();
                setWeeklyMenus(person, weeklyMenus, category);
            }
        }
        return new Menus(categories, matchingWeeklyMenus);
    }

    public Categories getCategories() {
        return categories;
    }

    public Map<Person, List<String>> getMatchingWeeklyMenus() {
        return Collections.unmodifiableMap(matchingWeeklyMenus);
    }

    private static void setWeeklyMenus(Person person, List<String> weeklyMenus, Menu category) {
        List<String> menus = category.getMenus();
        String menu;
        do {
            menu = Randoms.shuffle(menus).get(0);
        } while (weeklyMenus.contains(menu) || person.containsForbiddenMenus(menu));
        weeklyMenus.add(menu);
    }
}
