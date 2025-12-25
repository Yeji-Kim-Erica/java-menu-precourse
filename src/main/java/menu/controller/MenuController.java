package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

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
    }
}