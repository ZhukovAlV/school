package net.thumbtack.school.windows.managers;

import net.thumbtack.school.windows.v4.Desktop;
import net.thumbtack.school.windows.v4.base.Window;
import net.thumbtack.school.windows.v4.base.WindowErrorCode;
import net.thumbtack.school.windows.v4.base.WindowException;

public class PairManager<T extends Window,L extends Window>   {
    private T firstWindow;
    private L secondWindow;

    public T getFirstWindow() {
        return firstWindow;
    }

    public void setFirstWindow(T firstWindow) {
        this.firstWindow = firstWindow;
    }

    public L getSecondWindow() {
        return secondWindow;
    }

    public void setSecondWindow(L secondWindow) {
        this.secondWindow = secondWindow;
    }

    public PairManager(T firstWindow, L secondWindow) throws WindowException{
        super();
        if (firstWindow == null || secondWindow == null) throw new WindowException(WindowErrorCode.NULL_WINDOW);
        this.firstWindow = firstWindow;
        this.secondWindow = secondWindow;
    }
    public boolean allWindowsFullyVisibleOnDesktop (PairManager<? extends Window,? extends Window> pairManager, Desktop desktop) {
        return getFirstWindow().isFullyVisibleOnDesktop(desktop) && getSecondWindow().isFullyVisibleOnDesktop(desktop)
                && pairManager.getFirstWindow().isFullyVisibleOnDesktop(desktop) && pairManager.getSecondWindow().isFullyVisibleOnDesktop(desktop);
    }

    public static boolean allWindowsFullyVisibleOnDesktop (PairManager<? extends Window,? extends Window> pairManager1, PairManager<? extends Window,? extends Window> pairManager2, Desktop desktop) {
        return (pairManager1.allWindowsFullyVisibleOnDesktop(pairManager1,desktop)
                && pairManager2.allWindowsFullyVisibleOnDesktop(pairManager1,desktop));
    }

}
