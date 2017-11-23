package com.mycompany.app.Model;

public class ColorLine extends Line implements Colorable{
    private int color;

    public ColorLine(ColorPoint beg, ColorPoint end, int color) {
        super(beg, end);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorLine [color=" + color + ", Begine = " + getBeg() + ", End =" + getEnd() + "]";
    }
}
