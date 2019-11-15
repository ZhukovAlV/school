package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RoundWindow;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RoundButton extends RoundWindow {
    public RoundButton(Point center, int radius, WindowState state, String text) throws WindowException {
        super(center, radius, state, text);
    }
    public RoundButton(Point center, int radius, String state, String text) throws WindowException {
        super(center, radius, state, text);
    }
    public RoundButton(int xCenter, int yCenter, int radius, WindowState state, String text) throws WindowException{
        super(xCenter, yCenter, radius, state, text);
    }
    public RoundButton(int xCenter, int yCenter, int radius, String state, String text) throws WindowException{
        super(xCenter, yCenter, radius, state, text);
    }
    public RoundButton(Point center, int radius, String text) throws WindowException {
        super(center, radius, text);
    }
    public RoundButton(int xCenter, int yCenter, int radius, String text) throws WindowException {
        super(xCenter, yCenter, radius, text);
    }
}
