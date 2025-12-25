package menu.error;

/**
 * 오류 메시지를 정의한 enum 클래스
 */
public enum ErrorMessage {
    NAME_NULL_OR_BLANK("코치 이름은 공백이거나 비어 있을 수 없습니다."),
    INVALID_NAME_FORMAT("코치 이름 입력 형식이 올바르지 않습니다."),
    NAME_TOO_SHORT("코치 이름은 2글자 이상이어야 합니다."),
    NAME_TOO_LONG("코치 이름은 4글자 이하여야 합니다."),
    PEOPLE_UNDER_MINIMUM("코치는 최소 2명 이상 입력해야 합니다."),
    PEOPLE_OVER_MAXIMUM("코치는 최대 5명 이하로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
