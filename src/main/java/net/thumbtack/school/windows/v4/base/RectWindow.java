package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;

import java.awt.geom.RectangularShape;
import java.util.Objects;

import static java.lang.Math.abs;

public abstract class RectWindow extends Window {
    private Point topLeft,bottomRight;

    public Point getTopLeft() {
        return topLeft;
    }
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }
    public void setBottomRight(Point bottomRight) { this.bottomRight = bottomRight;
    }

    public RectWindow(Point topLeft, Point bottomRight) throws WindowException {
        setTopLeft(topLeft);
        setBottomRight(bottomRight);
        setState(WindowState.ACTIVE);
    }
    public RectWindow(Point topLeft, Point bottomRight, String text) throws WindowException {
        this(topLeft, bottomRight);
        setText(text);
    }
    public RectWindow(Point topLeft, Point bottomRight, WindowState state) throws WindowException {
        this(topLeft, bottomRight);
        setState(state);
    }
    public RectWindow(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException {
        this(topLeft, bottomRight, text);
        setState(state);
    }
    public RectWindow(Point topLeft, Point bottomRight, String state, String text) throws WindowException {
        this(topLeft, bottomRight, text);
        setState(state);
    }
    public RectWindow(int xLeft, int yTop, int width, int height) throws WindowException {
        this(new Point(xLeft,yTop), new Point(xLeft+width-1,yTop+height-1));
    }
    public RectWindow(int xLeft, int yTop, int width, int height, String text) throws WindowException {
        this(new Point(xLeft,yTop), new Point(xLeft+width-1,yTop+height-1), text);
    }
    public RectWindow(int xLeft, int yTop, int width, int height, WindowState state) throws WindowException {
        this(new Point(xLeft,yTop), new Point(xLeft+width-1,yTop+height-1), state);
    }
    public RectWindow(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException {
        this(new Point(xLeft,yTop), new Point(xLeft+width-1,yTop+height-1), state, text);
    }
    public RectWindow(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        this(new Point(xLeft,yTop), new Point(xLeft+width-1,yTop+height-1), state, text);
    }

    public int getWidth() {
        return abs(getBottomRight().getX()-getTopLeft().getX())+1;
    }
    public int getHeight() {
        return abs(getTopLeft().getY()-getBottomRight().getY())+1;
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());

    }
    public void moveTo(int x, int y) {
        moveRel(x - getTopLeft().getX(), y - getTopLeft().getY());
    }

    public void moveRel(int dx, int dy) {
        getTopLeft().moveRel(dx,dy);
        getBottomRight().moveRel(dx,dy);
    }

    public void resize (double ratio) {
        int x = getWidth();
        int width = ((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio);
        int height = ((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio);
        setBottomRight (new Point(getTopLeft().getX()+width-1,getTopLeft().getY()+height-1));
    }

    public boolean isInside(int x, int y) {
        return x >= getTopLeft().getX() && x <= getBottomRight().getX() && y >= getTopLeft().getY() && y <= getBottomRight().getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(RectButton rectButton) {
        for (int y=getTopLeft().getY(); y<=getBottomRight().getY(); y++ ) {
            for (int x=getTopLeft().getX(); x<=getBottomRight().getX(); x++ ) {
                if (rectButton.isInside(x,y)) return true;
            }
        }
        return false;
    }

    public boolean isInside(RectButton rectButton) {
        return (isInside(rectButton.getTopLeft()) && isInside(rectButton.getBottomRight()));
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return (0<=getTopLeft().getX() && getTopLeft().getX()<=desktop.getWidth() && desktop.getHeight()>=getTopLeft().getY() && getTopLeft().getY()>=0)
                && (0<=getBottomRight().getX() && getBottomRight().getX()<=desktop.getWidth() && desktop.getHeight()>=getBottomRight().getY() && getBottomRight().getY()>=0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectWindow that = (RectWindow) o;
        return Objects.equals(topLeft, that.topLeft) &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
