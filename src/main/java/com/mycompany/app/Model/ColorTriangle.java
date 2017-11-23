package com.mycompany.app.Model;

public class ColorTriangle extends Triangle implements Colorable{
    private ColorPoint apexA, apexB, apexC;
    private ColorLine sideAB, sideBC, sideCA;
    public ColorTriangle(String name, Point apexA, Point apexB, Point apexC, int color) {
        super(name);
        this.apexA = new ColorPoint(apexA, color);
        this.apexB = new ColorPoint(apexB, color);
        this.apexC = new ColorPoint(apexC, color);
        sideAB= new ColorLine(this.apexA, this.apexB, color);
        sideBC= new ColorLine(this.apexB, this.apexC, color);
        sideCA= new ColorLine(this.apexC, this.apexA, color);
    }

    public ColorPoint getApexA() {
        return apexA;
    }

    public ColorPoint getApexB() {
        return apexB;
    }

    public ColorPoint getApexC() {
        return apexC;
    }

    public Line getSideAB() {
        if (sideAB==null) sideAB = new ColorLine(apexA, apexB, 100);
        return sideAB;
    }
    public void setApexA(ColorPoint p) {
        int color = sideAB.getColor();
        apexA  = p;
        sideAB = new ColorLine(apexA, apexB, color);
        sideCA = new ColorLine(apexC, apexA, color);
    }
    public void setApexB(ColorPoint p) {
        int color = sideAB.getColor();
        apexB  = p;
        sideAB = new ColorLine(apexA, apexB, color);
        sideBC = new ColorLine(apexB, apexC, color);
    }
    public void setApexC(ColorPoint p) {
        int color = sideCA.getColor();
        apexC  = p;
        sideCA = new ColorLine(apexC, apexA, color);
        sideBC = new ColorLine(apexB, apexC, color);
    }
    public String toString() {
        return "ColorTrianle [apex A = " + getApexA() + ", apex B = " + getApexB() + ", apex C = " + getApexC() +"]";
    }
}
