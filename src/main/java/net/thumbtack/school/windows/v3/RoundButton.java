package net.thumbtack.school.windows.v3;

import net.thumbtack.school.windows.v3.base.RoundWindow;

import java.util.Objects;

public class RoundButton extends RoundWindow {
    public RoundButton(Point center, int radius, boolean active, String text) {
        super(center, radius, active, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, boolean active, String text) {
        super(xCenter, yCenter, radius, active, text);
    }

    public RoundButton(Point center, int radius, String text) {
        super(center, radius, text);
    }

    public RoundButton(int xCenter, int yCenter, int radius, String text) {
        super(xCenter, yCenter, radius, text);
    }
}
