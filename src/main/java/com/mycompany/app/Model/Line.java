package com.mycompany.app.Model;

public class Line extends Figure implements Cloneable{
    private Point beg;
    private Point end;

    public Line(String name, Point beg, Point end) {
        super(name);
        checkTrueLine(beg, end);
        this.beg = beg;
        this.end = end;

    }
    public Line(Point beg, Point end) {
        super("line");
        checkTrueLine(beg, end);
        this.beg = beg;
        this.end = end;
    }
    public Line(String name, int x1, int y1, int x2, int y2) {
        super(name);
        checkTrueLine(x1, y1, x2, y2);
        beg = new Point(x1,y1);
        end = new Point(x2,y2);
    }
    public Line(int x1, int y1, int x2, int y2) {
        super("line");
        checkTrueLine(x1, y1, x2, y2);
        beg = new Point(x1,y1);
        end = new Point(x2,y2);
    }
    public Point getBeg() { return beg;}
    public void setBeg(Point beg) {
        this.beg = beg;
    }
    public Point getEnd() {
        return end;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

    public static boolean checkTrueLine(int x1, int y1, int x2, int y2){
        double pointA = x2 - x1;
        double pointB = y2 - y1;
        if(pointA == 0 && pointB == 0) throw new IllegalArgumentException("На жаль лінію не можна побудувати," +
                                                                          " тому шо точки однакові");
        return true;
    }
    public static boolean checkTrueLine(Point beg, Point end){
        double pointA = end.getX() - beg.getX();
        double pointB = end.getY() - beg.getY();
        if(pointA == 0 && pointB == 0) throw new IllegalArgumentException("На жаль лінію не можна побудувати," +
                                                                            " тому шо точки однакові");
        return true;
    }

    public double determLengthSide(){
        double pointA = end.getX() - beg.getX();
        double pointB = end.getY() - beg.getY();
        return Math.sqrt(Math.pow(pointA, 2)+ Math.pow(pointB, 2));
    }

    @Override
    public Object clone()  {
        return super.clone();
    }

    @Override
    public boolean equals(Figure line)  {
        if(this == line){
            return true;
        }
        //if("Line".equals(line.getClass().getName())){
        if(this.getClass().getName() == line.getClass().getName()){
            if(this.beg.getX() == ((Line) line).beg.getX() && this.beg.getY() == ((Line) line).beg.getY() &&
               this.end.getX() == ((Line) line).end.getX() && this.end.getY() == ((Line) line).end.getY()){
                   return true;
            }
        }
        return false;
    }
    public String toString() {
        return "Line [Begine = " + getBeg() + ", End =" + getEnd() + "]";
    }
}
