package net.thumbtack.school.windows.v3;

import net.thumbtack.school.base.StringOperations;

import java.util.Arrays;

public class ListBox extends RectButton {

    private String[] lines;

    public ListBox(Point topLeft, Point bottomRight, boolean active, String[] lines) {
        super(topLeft,bottomRight,active,"");
        setLines(lines);
        this.lines = getLines();
    }

    public ListBox(int xLeft, int yTop, int width, int height, boolean active, String[] lines) {
        super(xLeft,yTop,width,height,active,"");
        setLines(lines);
        this.lines = getLines();
    }

    public ListBox(Point topLeft, Point bottomRight, String[] lines) {
        super(topLeft,bottomRight,"");
        setLines(lines);
        this.lines = getLines();
    }

    public ListBox(int xLeft, int yTop, int width, int height, String[] lines) {
        super(xLeft,yTop,width,height,"");
        setLines(lines);
        this.lines = getLines();
    }

    public String[] getLines() {
        return lines;
    }

    public void setLines(String[] lines) {
        if (lines != null) {
            this.lines = new String[lines.length];
            System.arraycopy(lines, 0, this.lines, 0, lines.length);
        } else this.lines = lines;
    }

    public String[] getLinesSlice(int from, int to) {
        if (getLines() == null) return null;
        String[] LinesSlice = new String[(getLines().length < to ? getLines().length : to) - from];
        System.arraycopy(getLines(), from, LinesSlice, 0, LinesSlice.length);
        return LinesSlice;
    }

    public String getLine(int index) {
        if ((lines != null) && (index < lines.length)) return lines[index];
        return null;
    }

    public void setLine(int index, String line) {
        if ((lines != null) && (index < lines.length))
            lines[index] = line;
    }

    public Integer findLine(String line) {
        if (getLines() != null) {
            for (int i = 0; i < getLines().length; i++)
                if (getLines()[i].equals(line)) return i;
        }
        return null;
    }

    public void reverseLineOrder() {
        if (getLines() != null) {
            String[] reverseArray = new String[getLines().length];
            for (int i = 0; i < lines.length; i++) {
                reverseArray[i] = getLines()[lines.length - 1 - i];
            }
            setLines(reverseArray);
        }
    }

    public void reverseLines() {
        if (getLines() != null) {
            for (int i = 0; i < getLines().length; i++) {
                setLine(i,StringOperations.reverse(getLines()[i]));
            }
        }
    }

    public void duplicateLines() {
        if (getLines() != null) {
            String[] dupArray = new String[getLines().length * 2];
            for (int i = 0; i < getLines().length; i++) {
                dupArray[i * 2] = getLines()[i];
                dupArray[i * 2 + 1] = getLines()[i];
            }
            setLines(dupArray);
        }
    }

    public void removeOddLines() {
        if (getLines()!=null && getLines().length!=1) {
            String[] remArray = new String[(int)Math.ceil((double)getLines().length / 2)];
            for (int i = 0, j = 0; i < remArray.length; i++, j+=2) {
                remArray[i]=getLines()[j];
            }
            setLines(remArray);
        }
    }

    public boolean isSortedDescendant() {
        if (lines != null && lines.length > 1) {
            for (int i = 0; i < lines.length - 1; i++) {
                if (StringOperations.isLess(lines[i], lines[i + 1])) return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ListBox listBox = (ListBox) o;
        return Arrays.equals(lines, listBox.lines);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(lines);
        return result;
    }
}
