package com.mycompany.app;

import com.mycompany.app.Model.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private static String name = "point";
    private static Point a;
    private static Point b;

    @Before public void init(){
        a = new Point(1,1);
        b = new Point(1,1);
    }
    @After
    public void destroy(){
        a = null;
        b = null;
    }
    /*@Test
    public void pointsOnOneLine() throws Exception {
        Point a = new Point(1,1);
        Point b = new Point(2,2);
        Point c = new Point(-1,-1);
        boolean result = Point.threePointsOnSameeLine(a,b,c);
        boolean expected = true;
        assertEquals("Три точки не на одной линии",result,expected);

        Point d = new Point(-1,1);
        result = result = Point.threePointsOnSameeLine(a,b,d);
        expected = false;
        assertEquals("Три точки на одной линии",result,expected);
    }*/

    @Test
    public void clonePoint(){//} throws Exception {
        Point b = (Point) a.clone();
        boolean actual= true;
        boolean expected = a.equals(b);
        assertEquals("Координати клонованої точки відрізняються від оригінальної",expected, actual);
    }

    @Test
    public void equals(){
        boolean actual = true;
        boolean expected = a.equals(b);
        assertEquals("Координати точок різні", expected, actual);
        actual = false;
        expected = b.equals(a);
        assertNotEquals("Координати точок однакові", expected, actual);
    }
}