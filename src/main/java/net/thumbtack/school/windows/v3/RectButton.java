package net.thumbtack.school.windows.v3;

import net.thumbtack.school.windows.v3.base.RectWindow;

import java.util.Objects;

import static java.lang.Math.abs;

public class RectButton extends RectWindow {
    public RectButton(Point topLeft, Point bottomRight, boolean active, String text) {
        super(topLeft, bottomRight, active, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, boolean active, String text) {
        super(xLeft, yTop, width, height, active, text);
    }

    public RectButton(Point topLeft, Point bottomRight, String text) {
        super(topLeft, bottomRight, text);
    }

    public RectButton(int xLeft, int yTop, int width, int height, String text) {
        super(xLeft, yTop, width, height, text);
    }
}
