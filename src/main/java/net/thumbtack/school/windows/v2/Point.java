package net.thumbtack.school.windows.v2;

import java.util.Objects;

public class Point {
    private int x;
    private int y;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public Point() {
        this.x=0;
        this.y=0;
    }

    public Point(Point point) {
        this.x=point.getX();
        this.y=point.getY();
    }

    public void moveTo(int x, int y){
        setX(x);
        setY(y);
    }

    public void moveRel(int dx, int dy) {
        setX(getX()+dx);
        setY(getY()+dy);
    }

    public boolean isVisibleOnDesktop(Desktop desktop){
        return 0<getX() && getX()<desktop.getWidth() && desktop.getHeight()>getY() && getY()>0;
    }

    public boolean isNotVisibleOnDesktop(Desktop desktop) {
        return desktop.getWidth()<=getX() || getX()<=0 || getY()<=0  || desktop.getHeight()<=getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
