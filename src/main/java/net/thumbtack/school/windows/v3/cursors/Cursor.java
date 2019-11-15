package net.thumbtack.school.windows.v3.cursors;

import net.thumbtack.school.windows.v3.Point;
import net.thumbtack.school.windows.v3.iface.Movable;

public class Cursor implements Movable {
    private int cursorForm;
    public int getCursorForm() {
        return cursorForm;
    }
    public void setCursorForm(int cursorForm) {
        this.cursorForm = cursorForm;
    }

    private int x;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    private int y;
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Cursor(int x, int y, int cursorForm) {
        this.x=x;
        this.y=y;
        this.cursorForm=cursorForm;
    }

    public Cursor(Point point, int cursorForm) {
        this.x=point.getX();
        this.y=point.getY();
        this.cursorForm=cursorForm;
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }

    public void moveRel(int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}
