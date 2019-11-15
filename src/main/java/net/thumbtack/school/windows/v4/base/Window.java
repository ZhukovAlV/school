package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;
import net.thumbtack.school.windows.v4.iface.Resizable;

import java.util.Objects;

public abstract class Window implements Resizable, Movable {

    private WindowState state;
    public WindowState getState() {
        return state;
    }

    public void setState(WindowState state) throws WindowException {
        checkForState(state, getState());
        //setState(state.name());
        this.state = state;
    }

    public void setState(String state) throws WindowException {
        checkForState(state, getState());
        //this.state = WindowState.fromString(state);
        setState(WindowState.fromString(state));
    }

    private String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return state == window.state &&
                text.equals(window.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, text);
    }

    abstract public boolean isInside(int x, int y);
    abstract public boolean isInside(Point point);
    abstract public boolean isFullyVisibleOnDesktop(Desktop desktop);


    static protected void checkForNull(Object input) throws WindowException {
        if (input == null) throw new WindowException(WindowErrorCode.EMPTY_ARRAY);
    }

    static protected void checkForIndex(int index, String[] lines) throws WindowException {
        if (index < 0 || index >= lines.length) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    static protected void checkForSlice(int from, int to, String[] lines) throws WindowException {
        if ((from < 0 || to > lines.length) || (from >= to)) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    static protected void checkForSelected(Integer selected, String[] lines) throws WindowException {
        if (selected < 0 || selected >= lines.length) throw new WindowException(WindowErrorCode.WRONG_INDEX);
    }

    static protected void checkForState(WindowState state, WindowState currentState) throws WindowException {
        if ((state == null)
                || ((currentState == null) && (state == WindowState.DESTROYED))
                || ((currentState == WindowState.DESTROYED) && (state != WindowState.DESTROYED))
                || ((currentState == WindowState.ACTIVE) && (state == WindowState.DESTROYED)))
            throw new WindowException(WindowErrorCode.WRONG_STATE);
    }

    static protected void checkForState(String state, WindowState currentState) throws WindowException {
        if (state == null) throw new WindowException(WindowErrorCode.WRONG_STATE);
        else checkForState(WindowState.fromString(state), currentState);
    }
}
