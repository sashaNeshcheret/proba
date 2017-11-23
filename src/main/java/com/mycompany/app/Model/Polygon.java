package com.mycompany.app.Model;

public class Polygon extends Figure {
    private Point [] points;

    /**
     *
     * @param points
     * @throws IllegalArgumentException
     */
    public Polygon(String name, Point ... points) throws IllegalArgumentException{
        super(name);
        if(points.length < 4)
            throw new IllegalArgumentException("У полігона повинно бути більше 3 точок");
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public double determPerimeter(){
        double perimeter = 0;
        Point oldPoint = new Point(0,0);;
        Point firstPoint = new Point(0,0);
        Point secondPoint;
        for(int i = 0; i < points.length; i++){
            if(i == 0){
                firstPoint = points[i];
                oldPoint = firstPoint;
            }
            else if(i != points.length-1){
                secondPoint = points[i];
                perimeter += new Line(firstPoint, secondPoint).determLengthSide();
            }
            if(i == points.length-1){
                firstPoint = points[i];
                perimeter += new Line(firstPoint, oldPoint).determLengthSide();
            }
        }
        return perimeter;
    }


}
