package menu.controller;

import menu.model.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

/**
 * 프로그램의 전체 흐름 조율을 담당하는 클래스
 */
public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();

        Persons persons = getPersons();
        matchForbiddenMenus(persons);

        Menus weeklyMenus = createWeeklyMenus(persons);
        outputView.printWeeklyMenus(weeklyMenus);
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Persons getPersons() {
        outputView.printNamesPrompt();
        return retry(this::parseNamesToPersons);
    }

    private Persons parseNamesToPersons() {
        return Persons.from(inputView.readNames());
    }

    private void matchForbiddenMenus(Persons persons) {
        for (Person person : persons.getPersons()) {
            outputView.printForbiddenMenusPrompt(person.getName());
            ForbiddenMenus menus = retry(this::getForbiddenMenus);
            person.setForbiddenMenus(menus);
        }
    }

    private ForbiddenMenus getForbiddenMenus() {
        return new ForbiddenMenus(inputView.readForbiddenMenus());
    }

    private Menus createWeeklyMenus(Persons persons) {
        Categories categories = new Categories();
        return Menus.of(persons, categories);
    }
}
