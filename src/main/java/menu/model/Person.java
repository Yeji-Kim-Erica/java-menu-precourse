package menu.model;

import menu.error.ErrorMessage;

public class Person {
    private final String name;
    private ForbiddenMenus forbiddenMenus;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    public void setForbiddenMenus(ForbiddenMenus forbiddenMenus) {
        this.forbiddenMenus = forbiddenMenus;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        int nameLength = name.length();
        if (nameLength < 2) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_SHORT.getMessage());
        }
        if (nameLength > 4) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
        }
    }

    public boolean containsForbiddenMenus(String menu) {
        return forbiddenMenus.contains(menu);
    }
}
