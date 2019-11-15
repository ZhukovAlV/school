package net.thumbtack.school.windows.v4;

import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

public class ComboBox extends ListBox {
    private Integer selected;
    public Integer getSelected() {
        return selected;
    }
    public void setSelected(Integer selected) throws WindowException {
        if (selected != null) {
            checkForNull(getLines());
            checkForSelected(selected, getLines());}
        this.selected = selected;
    }

    public ComboBox(Point topLeft, Point bottomRight, String[] lines, Integer selected) throws WindowException{
        super(topLeft, bottomRight, lines);
        setSelected(selected);
    }
    public ComboBox(Point topLeft, Point bottomRight, WindowState state, String[] lines, Integer selected) throws WindowException{
        this(topLeft, bottomRight, lines, selected);
        setState(state);
    }
    public ComboBox(Point topLeft, Point bottomRight, String state, String[] lines, Integer selected) throws WindowException{
        this(topLeft, bottomRight, lines, selected);
        setState(state);
    }
    public ComboBox(int xLeft, int yTop, int width, int height, String[] lines, Integer selected) throws WindowException {
        super(xLeft, yTop, width, height, lines);
        if (selected != null) {
            checkForNull(lines);
            checkForSelected(selected, lines);
        }
        setSelected(selected);
    }
    public ComboBox(int xLeft, int yTop, int width, int height, WindowState state, String[] lines, Integer selected) throws WindowException{
        this(xLeft, yTop, width, height, lines, selected);
        setState(state);
    }
    public ComboBox(int xLeft, int yTop, int width, int height, String state, String[] lines, Integer selected) throws WindowException{
        this(xLeft, yTop, width, height, lines, selected);
        setState(state);
    }

    @Override
    public void setLines(String[] lines) {
        selected = null;
        super.setLines(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComboBox comboBox = (ComboBox) o;
        return selected != null ? selected.equals(comboBox.selected) : comboBox.selected == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (selected != null ? selected.hashCode() : 0);
        return result;
    }
}
