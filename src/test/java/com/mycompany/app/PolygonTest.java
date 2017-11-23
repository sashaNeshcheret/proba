package com.mycompany.app;


import com.mycompany.app.Model.Line;
import com.mycompany.app.Model.Point;
import com.mycompany.app.Model.Polygon;
import com.mycompany.app.Model.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonTest {
    private static Point a;
    private static Point b;
    private static Point c;
    private static Point d;
    private static Point e;
    Polygon polygon;

    @Before
    public void init(){
        Point a = new Point(0,0);
        Point b = new Point(0,2);
        Point c = new Point(1,4);
        Point d = new Point(2,2);
        Point e = new Point(2,0);
    }
    @After
    public void destroy(){
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        polygon = null;

    }
    @Test(expected = IllegalArgumentException.class)
    public void createPoliginWithWrongNumberOfPoints(){
        Polygon polygon = new Polygon("Polygon", a, b, c);
    }
/*
    @Test
    public void createPoligin() throws Exception {
        Polygon polygon = new Polygon("Polygon", a, b, c, d, e);
        double actual = 11.6568;
        Point[] poi = polygon.getPoints();
        for(Point p : poi){
            System.out.println(p);
        }
        double expected = polygon.determPerimeter();
        assertEquals("Периметр розраховано невірно", expected, actual, 0.0001);
    }*/
}