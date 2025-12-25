package menu.view;

import menu.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.lang.System.out;

/**
 * 프로그램의 모든 출력을 담당하는 클래스
 */
public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

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

    public void printWeeklyMenus(Menus menus) {
        printBlankLine();
        out.println("메뉴 추천 결과입니다.");
        out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printWeeklyCategories(menus.getCategories());
        printWeeklyMenuResult(menus);
    };

    private void printBlankLine() {
        out.println();
    }

    private void printWeeklyCategories(Categories categories) {
        List<String> weeklyCategories = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            weeklyCategories.add(categories.getCategory(i).toString());
        }
        out.printf("[ 카테고리 | %s ]\n", String.join(" | ", weeklyCategories));
    };

    private void printWeeklyMenuResult(Menus menus) {
        Map<Person, List<String>> matchingWeeklyMenus = menus.getMatchingWeeklyMenus();
        for (Entry<Person, List<String>> entry : matchingWeeklyMenus.entrySet()) {
            out.printf("[ %s | %s ]\n", entry.getKey(), String.join(" | ", entry.getValue()));
        }
    };
}
