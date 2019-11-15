package net.thumbtack.school.windows.v3.base;

import net.thumbtack.school.windows.v3.Desktop;
import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.iface.Movable;
import net.thumbtack.school.windows.v3.iface.Resizable;

public abstract class Window implements Resizable, Movable {

    private boolean active;
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    private String text;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    abstract public boolean equals(Object o);
    abstract public int hashCode();
    abstract public boolean isInside(int x, int y);
    abstract public boolean isInside(Point point);
    abstract public boolean isFullyVisibleOnDesktop(Desktop desktop);
}
