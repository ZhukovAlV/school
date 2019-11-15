package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class RadioButton extends RoundButton {
    private boolean checked;
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public RadioButton(Point center, int radius, String text, boolean checked) throws WindowException{
        super(center, radius, text);
        this.checked=checked;
    }
    public RadioButton(Point center, int radius, WindowState state, String text, boolean checked) throws WindowException{
        this(center, radius, text, checked);
        setState(state);
    }
    public RadioButton(Point center, int radius, String state, String text, boolean checked) throws WindowException{
        this(center, radius, text, checked);
        setState(state);
    }
    public RadioButton(int xCenter, int yCenter, int radius, String text, boolean checked) throws WindowException{
        this(new Point(xCenter,yCenter), radius, text, checked);
    }
    public RadioButton(int xCenter, int yCenter, int radius, WindowState state, String text, boolean checked) throws WindowException {
        this(new Point(xCenter,yCenter), radius, state, text, checked);
    }
    public RadioButton(int xCenter, int yCenter, int radius, String state, String text, boolean checked) throws WindowException {
        this(new Point(xCenter,yCenter), radius, state, text, checked);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RadioButton that = (RadioButton) o;
        return checked == that.checked;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (checked ? 1 : 0);
        return result;
    }
}
