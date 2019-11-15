package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class WindowFactory {

    private static int rectButtonCount = 0;
    private static int roundButtonCount = 0;

    public static void setRectButtonCount(int rectButtonCount) {
        WindowFactory.rectButtonCount = rectButtonCount;
    }

    public static void setRoundButtonCount(int roundButtonCount) {
        WindowFactory.roundButtonCount = roundButtonCount;
    }

    public static int getRectButtonCount() {
        return rectButtonCount;
    }

    public static int getRoundButtonCount() {
        return roundButtonCount;
    }

    public static RectButton createRectButton(Point leftTop, Point rightBottom, WindowState state, String text) throws WindowException {
        setRectButtonCount(getRectButtonCount()+1);
        return new RectButton(leftTop, rightBottom, state, text);
    }

    public static RoundButton createRoundButton(Point center, int radius, WindowState state, String text) throws WindowException{
        setRoundButtonCount(getRoundButtonCount()+1);
        return new RoundButton(center, radius, state, text);
    }

    public static int getWindowCount() {
        return getRectButtonCount() + getRoundButtonCount();
    }

    public static void reset() {
        setRectButtonCount(0);
        setRoundButtonCount(0);
    }

}
