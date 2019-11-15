package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.RectWindow;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RectButton extends RectWindow {

    public RectButton(Point topLeft, Point bottomRight) throws WindowException{
        super(topLeft, bottomRight);
    }
    public RectButton(Point topLeft, Point bottomRight, WindowState state) throws WindowException{
        super(topLeft, bottomRight, state);
    }
    public RectButton(Point topLeft, Point bottomRight, String text) throws WindowException{
        super(topLeft, bottomRight, text);
    }
    public RectButton(Point topLeft, Point bottomRight, WindowState state, String text) throws WindowException{
        super(topLeft, bottomRight, state, text);
    }
    public RectButton(Point topLeft, Point bottomRight, String state,  String text) throws WindowException{
        super(topLeft, bottomRight, state, text);
    }
    public RectButton(int xLeft, int yTop, int width, int height) throws WindowException{
        super(xLeft, yTop, width, height);
    }
    public RectButton(int xLeft, int yTop, int width, int height, String text) throws WindowException{
        super(xLeft, yTop, width, height, text);
    }
    public RectButton(int xLeft, int yTop, int width, int height, WindowState state) throws WindowException{
        super(xLeft, yTop, width, height, state);
    }
    public RectButton(int xLeft, int yTop, int width, int height, WindowState state, String text) throws WindowException{
        super(xLeft, yTop, width, height, state, text);
    }
    public RectButton(int xLeft, int yTop, int width, int height, String state, String text) throws WindowException {
        super(xLeft, yTop, width, height, state, text);
    }
}
