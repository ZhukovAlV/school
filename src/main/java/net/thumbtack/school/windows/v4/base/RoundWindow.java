package net.thumbtack.school.windows.v4.base;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.Point;

import java.util.Objects;

public abstract class RoundWindow extends Window {
    private Point center;
    private int radius;

    public Point getCenter() {
        return center;
    }
    public void setCenter(Point center) {
        this.center = center;
    }
    public void setCenter(int x, int y) {
        setCenter (new Point(x, y));
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public RoundWindow(Point center, int radius, String text) throws WindowException {
        setCenter(center);
        setRadius(radius);
        setText(text);
        setState(WindowState.ACTIVE);
    }
    public RoundWindow(Point center, int radius, WindowState state, String text) throws WindowException {
        this(center,radius,text);
        setState(state);
    }
    public RoundWindow(Point center, int radius, String state, String text) throws WindowException {
        this(center,radius,text);
        setState(state);
    }
    public RoundWindow(int xCenter, int yCenter, int radius, String text) throws WindowException {
        this(new Point(xCenter,yCenter), radius, text);
    }
    public RoundWindow(int xCenter, int yCenter, int radius, WindowState state, String text) throws WindowException {
        this(new Point(xCenter,yCenter), radius, state, text);
    }
    public RoundWindow(int xCenter, int yCenter, int radius, String state, String text) throws WindowException {
        this(new Point(xCenter,yCenter), radius, state, text);
    }

    public void moveTo(int x, int y) {
        setCenter(new Point(x, y));
    }

    public void moveTo(Point point) {
        setCenter(point);
    }

    public void moveRel(int dx, int dy) {
        setCenter(new Point(getCenter().getX() + dx, getCenter().getY() + dy));
    }

    public void resize(double ratio) {
        setRadius ((getRadius() * ratio < 1) ? 1 : (int) (getRadius() * ratio));
    }

    public boolean isInside(int x, int y) {
        /* Если выбрать точку на координатной плоскости, то можно увидеть, что проекции ее координат на
        оси x и y являются катетами прямоугольного треугольника. А гипотенуза этого прямоугольного треугольника
        как раз показывает расстояние от начала координат до точки. Таким образом, если длина гипотенузы будет
        меньше радиуса круга, то точка будет принадлежать кругу; иначе она будет находится за его пределами.
        Длину гипотенузы можно вычислить по теореме Пифагора: квадрат гипотенузы равен сумме квадратов катетов.*/
        double d = Math.sqrt(Math.pow(getCenter().getX() - x,2) + Math.pow(getCenter().getY() - y,2));
        return (d <= getRadius());
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return (getCenter().getX() - getRadius() >= 0) && (getCenter().getX() + getRadius() < desktop.getWidth())
                &&  (getCenter().getY() - getRadius() >= 0) && (getCenter().getY() + getRadius() < desktop.getHeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoundWindow that = (RoundWindow) o;
        return radius == that.radius &&
                center.equals(that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), center, radius);
    }
}
