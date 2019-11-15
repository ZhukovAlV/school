package net.thumbtack.school.windows.v1;

import java.util.Objects;

import static java.lang.Math.abs;

public class RectButton {
    private boolean status;
    private Point TopLeft,BottomRight;

    public Point getTopLeft() {
        return TopLeft;
    }

    public void setTopLeft(Point topLeft) {
        TopLeft = topLeft;
    }

    public Point getBottomRight() {
        return BottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        BottomRight = bottomRight;
    }

    public boolean isActive() {
        return status;
    }
    public void setActive(boolean status) {
        this.status = status;
    }

    public RectButton(Point topLeft, Point bottomRight, boolean active) {
        setTopLeft(topLeft);
        setBottomRight(bottomRight);
        setActive(active);
    }
    public RectButton(int xLeft, int yTop, int width, int height, boolean active) {
        setTopLeft(new Point(xLeft,yTop));
        setBottomRight(new Point(xLeft+width-1,yTop+height-1));
        setActive(active);
    }
    public RectButton(Point topLeft, Point bottomRight) {
        setTopLeft(topLeft);
        setBottomRight(bottomRight);
        setActive(true);
    }
    public RectButton(int xLeft, int yTop, int width, int height) {
        setTopLeft(new Point(xLeft,yTop));
        setBottomRight(new Point(xLeft+width-1,yTop+height-1));
        setActive(true);
    }
    public int getWidth() {
        return abs(getBottomRight().getX()-getTopLeft().getX())+1;
    }
    public int getHeight() {
        return abs(getTopLeft().getY()-getBottomRight().getY())+1;
    }

    public void moveTo(int x, int y) {
        setBottomRight(new Point(x+getWidth()-1,y+getHeight()-1));
        setTopLeft(new Point(x,y));
    }

    public void moveTo(Point point) {
        setBottomRight(new Point(point.getX()+getWidth()-1,point.getY()+getHeight()-1));
        setTopLeft(new Point(point.getX(),point.getY()));
    }

    public void moveRel(int dx, int dy) {
        setBottomRight (new Point(getTopLeft().getX()+getWidth()+dx-1,getTopLeft().getY()+getHeight()+dy-1));
        setTopLeft(new Point(getTopLeft().getX()+dx,getTopLeft().getY()+dy));

    }

    public void resize(double ratio) {
      int x = getWidth();
        int width = ((getWidth() * ratio) < 1) ? 1 : (int) (getWidth() * ratio);
        int height = ((getHeight() * ratio) < 1) ? 1 : (int) (getHeight() * ratio);
        setBottomRight (new Point(getTopLeft().getX()+width-1,getTopLeft().getY()+height-1));
    }

    public boolean isInside(int x, int y) {
        return x >= getTopLeft().getX() && x <= getBottomRight().getX() && y >= getTopLeft().getY() && y <= getBottomRight().getY();
    }

    public boolean isInside(Point point) {
        return (point.getX() >= getTopLeft().getX() && point.getX() <= getBottomRight().getX() &&  point.getY()  >= getTopLeft().getY() && point.getY() <= getBottomRight().getY());
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
        RectButton that = (RectButton) o;
        return status == that.status &&
                Objects.equals(TopLeft, that.TopLeft) &&
                Objects.equals(BottomRight, that.BottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, TopLeft, BottomRight);
    }
}
