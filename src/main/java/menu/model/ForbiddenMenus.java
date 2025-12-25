package menu.model;

import menu.error.ErrorMessage;

import java.util.List;

public class ForbiddenMenus {
    private final List<String> menus;

    public ForbiddenMenus(List<String> menus) {
        validate(menus);
        this.menus = menus;
    }

    private void validate(List<String> menus) {
        int size = menus.size();
        if (size > 2) {
            throw new IllegalArgumentException(ErrorMessage.MENUS_OVER_MAXIMUM.getMessage());
        }
    }
}
