package menu;

import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

/**
 * 프로그램 진입점을 담당하는 클래스
 */
public class Application {
    public static void main(String[] args) {
        MenuController controller = appConfig();
        controller.run();
    }

    private static MenuController appConfig() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new MenuController(inputView, outputView);
    }
}
