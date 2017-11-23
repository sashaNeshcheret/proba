package com.mycompany.app.Model;

/**
 * Created by Нещерет on 15.11.2017.
 */
public class ColorPoint extends Point implements Colorable{
    private int color;
    public ColorPoint(int x, int y, int color) {
        super(x, y);
        this.color = color;
    }
    public ColorPoint(String name, Point a, int color) {
        super(name, a);
        this.color = color;
    }
    public ColorPoint(Point a, int color) {
        super(a);
        this.color = color;
    }
    public ColorPoint(String name, int x, int y, int color) {
        super(name, x, y);
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
        return "ColorPoint [color=" + color + ", X=" + getX() + ", Y=" + getY() + "]";
    }
}
