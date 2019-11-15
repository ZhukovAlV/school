package net.thumbtack.school.windows.v3;

public class RectButton3D extends RectButton {
    private int zHeight;
    public int getZHeight() {
        return zHeight;
    }
    public void setZHeight(int zHeight) {
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, boolean active, String text, int zHeight) {
        super(topLeft, bottomRight, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, boolean active, String text, int zHeight) {
        super(xLeft, yTop, width, height, active, text);
        this.zHeight = zHeight;
    }

    public RectButton3D(Point topLeft, Point bottomRight, String text, int zHeight) {
        super(topLeft, bottomRight, text);
        this.zHeight = zHeight;
        setActive(true);
    }

    public RectButton3D(int xLeft, int yTop, int width, int height, String text, int zHeight) {
        super(xLeft, yTop, width, height, text);
        this.zHeight = zHeight;
        setActive(true);
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
