package net.thumbtack.school.windows.v3;

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

    public static RectButton createRectButton(Point leftTop, Point rightBottom, boolean active, String text) {
        setRectButtonCount(getRectButtonCount()+1);
        return new RectButton(leftTop, rightBottom, active, text);
    }

    public static RoundButton createRoundButton(Point center, int radius, boolean active, String text) {
        setRoundButtonCount(getRoundButtonCount()+1);
        return new RoundButton(center, radius, active, text);
    }

    public static int getWindowCount() {
        return getRectButtonCount() + getRoundButtonCount();
    }

    public static void reset() {
        setRectButtonCount(0);
        setRoundButtonCount(0);
    }

}
