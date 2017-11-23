package com.mycompany.app;

import com.mycompany.app.Model.Line;
import com.mycompany.app.Model.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    private static Point a;
    private static Point b;
    private static Line line1;
    private static Line line2;
    private static Line line3;

    @Before
    public void init(){
        a = new Point(0,0);
        b = new Point(0,0);
        line1 = new Line(0,0,7,7);
        line2 = new Line(0,0,7,7);
        line3 = new Line(0,1,7,7);
    }
    @After
    public void destroy(){
        a = null;
        b = null;
        line1 = null;
        line2 = null;
        line3 = null;
    }
    @Test(expected = IllegalArgumentException.class)
    public void wrongPoints() {
        Line line = new Line(a, b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongCoordinate(){
        Line line = new Line(7,7,7,7);
    }

    @Test
    public void determLengthSide() {
        Line a = new Line(0, 0, 7, 7);
        double expected = a.determLengthSide();
        double actual = 9.8994;
        assertEquals("Длина линии нек верна", expected, actual, 0.0001);
    }
    @Test
    public void cloneLine() throws Exception {
        Line line2 = (Line)line1.clone();
        boolean expected   = line1.equals(line2);
        boolean actual = true;
        assertEquals("Координати точок лінії відрізняються від оригінальних", expected, actual);
    }
    @Test
    public void equals() throws Exception {
        boolean actual = true;
        boolean expected = line1.equals(line2);
        assertEquals("Лінії різні", expected, actual);

        expected = line1.equals(line3);
        assertNotEquals("Лінії однакові", expected, actual);
    }
}