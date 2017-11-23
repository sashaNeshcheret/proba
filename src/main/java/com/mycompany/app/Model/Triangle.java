package com.mycompany.app.Model;

public class Triangle extends  Figure implements Cloneable{
    private Point apexA, apexB, apexC;
    private Line sideAB, sideBC, sideCA;
    public Triangle(String name, Point apexA, Point apexB, Point apexC) {
        super(name);
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        sideAB= new Line(apexA, apexB);
        sideBC= new Line(apexB, apexC);
        sideCA= new Line(apexC, apexA);
        if(checkNotExistTriangle(sideAB, sideBC, sideCA)){
            throw new IllegalArgumentException("На жаль трикутник не можна побудувати, тому шо лінії на одній прямій");
        }
    }
    public Triangle(String name) {
        super(name);
    }


    public Point getApexA() {
        return apexA;
    }
    public Point getApexB() {
        return apexB;
    }
    public Point getApexC() {
        return apexC;
    }

    public Line getSideAB() {
        if (sideAB==null) sideAB = new Line(apexA, apexB);
        return sideAB;
    }
    public Line getSideBC() {
        if (sideBC==null) sideBC = new Line(apexB, apexC);
        return sideBC;
    }
    public Line getSideCA() {
        if (sideCA==null) sideCA = new Line(apexC, apexA);
        return sideCA;
    }

    public void setApexA(Point p) {
        apexA=p;
        sideAB=null;
        sideCA=null;
        getSideAB();
        getSideCA();
    }
    public void setApexB(Point p) {
        apexB=p;
        sideAB=null;
        sideBC=null;
        getSideAB();
        getSideBC();
    }
    public void setApexC(Point p) {
        apexC=p;
        sideCA=null;
        sideBC=null;
        getSideCA();
        getSideBC();
    }


    public double determPerimeter(){
        double perimeter =  sideAB.determLengthSide() +
                            sideBC.determLengthSide() +
                            sideCA.determLengthSide();
        return perimeter;
    }
    public double determArea(){
        double area  =  Math.sqrt(determPerimeter()/2*
                        (determPerimeter()/2- getSideAB().determLengthSide())*
                        (determPerimeter()/2- getSideBC().determLengthSide())*
                        (determPerimeter()/2- getSideCA().determLengthSide()));
        return area;
    }
    public static boolean checkNotExistTriangle(Line sideAB, Line sideBC, Line sideCA){
        if(sideAB.determLengthSide() == (sideBC.determLengthSide() + sideCA.determLengthSide()) ||
           sideBC.determLengthSide() == (sideAB.determLengthSide() + sideCA.determLengthSide()) ||
           sideCA.determLengthSide() == (sideBC.determLengthSide() + sideAB.determLengthSide())){
            return true;
        }
        return false;
    }
    @Override
    public Object clone()  {
        return super.clone();
    }

    public String toString() {
        return "Trianle [apex A = " + getApexA() + ", apex B = " + getApexB() + ", apex C = " + getApexC() +"]";
    }
}
