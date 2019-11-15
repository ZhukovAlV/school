package net.thumbtack.school.windows.v4.cursors;

import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.iface.Movable;

public class Cursor implements Movable {
    private CursorForm cursorForm;
    public CursorForm getCursorForm() {
        return cursorForm;
    }
    public void setCursorForm(CursorForm cursorForm) {
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

    public Cursor(Point point, CursorForm cursorForm) {
        this.x=point.getX();
        this.y=point.getY();
        this.cursorForm=cursorForm;
    }
    public Cursor(int x, int y, CursorForm cursorForm) {
        this(new Point(x,y), cursorForm);
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
