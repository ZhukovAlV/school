package net.thumbtack.school.windows.v4.base;

public enum WindowErrorCode {

    NULL_WINDOW ("Был передан null вместо окна."),
    WRONG_STATE ("При создании окна передается WindowState.DESTROYED или null."),
    WRONG_INDEX ("Передан недопустимый индекс для массива строк."),
    EMPTY_ARRAY("Массив строк равен null.");

    private String errorString;

    WindowErrorCode(String errorString) {
        setErrorString(errorString);
    }
    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
