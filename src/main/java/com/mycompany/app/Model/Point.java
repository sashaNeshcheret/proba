package com.mycompany.app.Model;

public class Point extends Figure{
    private int x;
    private int y;

    public Point(String name, int x, int y) {
        super(name);
        this.x = x;
        this.y = y;
    }
    public Point(String name, Point a) {
        super(name);
        this.x = a.getX();
        this.y = a.getY();
    }
    public Point(Point a) {
        super("point");
        this.x = a.getX();
        this.y = a.getY();
    }
    public Point(int x, int y) {
        super("point");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Object clone()  {
            return super.clone();
    }

    @Override
    public boolean equals(Figure point)  {
        if(this == point){
            return true;
        }
        if(this.getClass().getName() == point.getClass().getName()){
            if(this.x == ((Point) point).getX() && this.y == ((Point) point).getY()){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}
