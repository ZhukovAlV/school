package net.thumbtack.school.windows.v4.base;

public class WindowException extends Exception {
    private WindowErrorCode windowErrorCode;
    public WindowErrorCode getWindowErrorCode() {
        return windowErrorCode;
    }
    public void setWindowErrorCode(WindowErrorCode windowErrorCode) {
        this.windowErrorCode = windowErrorCode;
    }

    public WindowException(WindowErrorCode windowsErrorCode){
        setWindowErrorCode(windowsErrorCode);
    }
}
