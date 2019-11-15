package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.cursors.Cursor;
import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class ArrayManager<T extends Window> {
    private T[] windows;

    public ArrayManager(T[] window) throws WindowException {
        super();
        for (T elem: window
             ) {
            if (elem == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        }
        this.windows = window;
    }

    public T[] getWindows() {
        return windows;
    }

    public void setWindows(T[] window) {
        this.windows = window;
    }

    public T getWindow(int i) {
        return windows[i];
    }

    public void setWindow(T window, int i) {
        this.windows[i] = window;
    }

    public Boolean isSameSize (ArrayManager<? extends Window> arr) {
        return getWindows().length==arr.getWindows().length;
    }

    public boolean allWindowsFullyVisibleOnDesktop(Desktop desktop) {
        for (T elem: getWindows()
             ) {
            if (!elem.isFullyVisibleOnDesktop(desktop)) return false;
        }
        return true;
    }

    public boolean anyWindowFullyVisibleOnDesktop(Desktop desktop) {
        for (T elem: getWindows()
        ) {
            if (elem.isFullyVisibleOnDesktop(desktop)) return true;
        }
        return false;
    }

    public Window getFirstWindowFromCursor(Cursor cursor) {
        for (T elem: getWindows()
        ) {
            if (elem.isInside(cursor.getX(),cursor.getY())) return elem;
        }
        return null;
    }
}
