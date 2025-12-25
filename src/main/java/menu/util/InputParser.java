package menu.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 입력을 변환, 검증하는 유틸리티 클래스
 */
public final class InputParser {
    private InputParser() {}

    public static String refineInput(String input, String errorMessage) {
        boolean isNullOrBlank = (input == null) || input.isBlank();
        if (isNullOrBlank) {
            throw new IllegalArgumentException(errorMessage);
        }
        return input.trim();
    }

    public static List<String> parseToNames(String input, String errorMessage) {
        List<String> result = new ArrayList<>();
        for (String name : input.split(",")){
            String refinedName = refineInput(name, errorMessage);
            result.add(refinedName);
        };
        return result;
    }

    public static List<String> parseToForbiddenMenus(String input, String errorMessage) {
        List<String> result = new ArrayList<>();
        if ((input == null) || input.isBlank()) {
            return result;
        }
        for (String name : input.split(",")){
            String refinedName = refineInput(name, errorMessage);
            result.add(refinedName);
        };
        return result;
    }
}
