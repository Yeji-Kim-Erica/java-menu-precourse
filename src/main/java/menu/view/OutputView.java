package menu.view;

import menu.model.Persons;

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
    };

    public void printNamesPrompt() {
        printBlankLine();
        out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    };

    public void printForbiddenMenusPrompt(String name) {
        printBlankLine();
        out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n", name);
    };
}
