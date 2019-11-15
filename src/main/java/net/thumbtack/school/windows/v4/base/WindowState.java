package net.thumbtack.school.windows.v4.base;

public enum WindowState {
    ACTIVE,
    INACTIVE,
    DESTROYED;

    public static WindowState fromString(String stateString) {
        switch (stateString) {
            case ("ACTIVE"):
                return ACTIVE;
            case ("INACTIVE"):
                return INACTIVE;
            case ("DESTROYED"):
                return DESTROYED;
        }
        return null;
    }
}
