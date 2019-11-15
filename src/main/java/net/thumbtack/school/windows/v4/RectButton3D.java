package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RectButton3D extends RectButton {
    private int zHeight;
    public int getZHeight() {
        return zHeight;
    }
    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, WindowState state, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, state, text);
        this.zHeight = zHeight;
    }
    public RectButton3D(Point topLeft, Point bottomRight, String state, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, state, text);
        this.zHeight = zHeight;
    }
    public RectButton3D(int xLeft, int yTop, int width, int height, WindowState state, String text, int zHeight) throws WindowException {
        super(xLeft, yTop, width, height, state, text);
        this.zHeight = zHeight;
    }
    public RectButton3D(int xLeft, int yTop, int width, int height, String state, String text, int zHeight) throws WindowException {
        super(xLeft, yTop, width, height, state, text);
        this.zHeight = zHeight;
    }
    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) throws WindowException {
        super(topLeft, bottomRight, text);
        this.zHeight = zHeight;
        setState(WindowState.ACTIVE);
    }
    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) throws WindowException {
        super(xLeft, yTop, width, height, text);
        this.zHeight = zHeight;
        setState(WindowState.ACTIVE);
    }

    public boolean isInside(RectButton3D rectButton3D) {
        // левая точка не правее правой, верхняя точка не выше нижней, высота по оси Z больше 0.
        return isInside(rectButton3D.getTopLeft()) && isInside(rectButton3D.getBottomRight()) && (getZHeight() >= rectButton3D.getZHeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectButton3D that = (RectButton3D) o;
        return zHeight == that.zHeight;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + zHeight;
        return result;
    }
}
