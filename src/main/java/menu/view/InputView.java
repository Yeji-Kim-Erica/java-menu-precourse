package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.error.ErrorMessage;
import menu.util.InputParser;

import java.util.List;

/**
 * 프로그램의 모든 입력을 담당하는 클래스
 */
public class InputView {
    public List<String> readNames() {
        String input = Console.readLine();
        String refinedInput = InputParser.refineInput(input, ErrorMessage.NAME_NULL_OR_BLANK.getMessage());
        return InputParser.parseToNames(refinedInput, ErrorMessage.INVALID_NAME_FORMAT.getMessage());
    }
}
