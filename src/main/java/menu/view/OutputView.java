package menu.view;

import static java.lang.System.out;

/**
 * 프로그램의 모든 출력을 담당하는 클래스
 */
public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printBlankLine() {
        out.println();
    }

    public void printErrorMessage(IllegalArgumentException e) {
        out.println(ERROR_PREFIX + e.getMessage());
    }

    public void printStart() {
        out.println("점심 메뉴 추천을 시작합니다.");
        printBlankLine();
    };
}
