package menu.controller;

import menu.model.Persons;
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

        Persons persons = retry(this::getPersons);
    }

    private Persons getPersons() {
        outputView.printNamesPrompt();
        return Persons.from(inputView.readNames());
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
}
