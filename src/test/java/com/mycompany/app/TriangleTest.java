package com.mycompany.app;

import com.mycompany.app.Model.Line;
import com.mycompany.app.Model.Point;
import com.mycompany.app.Model.Triangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    private static Point a;
    private static Point b;
    private static Point c;
    private static Line lineAB;
    private static Line lineBC;
    private static Line lineCA;
    private static Triangle triangle;

    @Before
    public void init(){
        a = new Point(0,0);
        b = new Point(3,0);
        c = new Point(0,4);
        lineAB = new Line(a, b);
        lineBC = new Line(b, c);
        lineCA = new Line(c, a);
        triangle = new Triangle("Triangle", a, b, c);
    }
    @After
    public void destroy(){
        a = null;
        b = null;
        c = null;
        lineAB = null;
        lineAB = null;
        lineAB = null;
        triangle = null;
    }

    @Test
    public void checkNotExistTriangle(){
        lineAB = new Line(0, 0, 2, 0);
        lineBC = new Line(2,0,4,0);
        lineCA = new Line(4,0,0,0);
        boolean actual = true;
        boolean expected = Triangle.checkNotExistTriangle(lineAB, lineBC, lineCA);
        assertEquals("Трикутник створити неможливо, точки лежать на одній прямій",expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void createTriangleWithWrongPoints(){
        a = new Point(0,0);
        b = new Point(2,0);
        c = new Point(4,0);
        Triangle triangle = new Triangle("Triangle", a, b, c);
    }

    @Test
    public void getPerimeter() throws Exception {
        Triangle triangle = new Triangle("Triangle",a,b,c);
        double actual = 12.0;
        double expected = triangle.determPerimeter();
        assertEquals("Периметр пораховано невірно", expected,actual, 0.0001);
    }
    @Test
    public void getArea() throws Exception {
        Triangle triangle = new Triangle("Triangle",a,b,c);
        double actual = 6;
        double expected = triangle.determArea();
        assertEquals("Площа порахована невірно",expected, actual,0.01);
    }

    @Test
    public void setApexA(){
        triangle.setApexA(new Point(2,2));
        Line line = new Line(2,2,3,0);
        Line newLine = triangle.getSideAB();
        boolean expected = line.equals(newLine);
        assertTrue("Сторона АВ побудована неправильно", expected);
        line = new Line(0,4,2,2);
        newLine = triangle.getSideCA();
        expected = line.equals(newLine);
        assertTrue("Сторона CA побудована неправильно", expected);
    }
    @Test
    public void setApexB(){
        triangle.setApexB(new Point(2,2));
        Line line = new Line(0,0,2,2);
        Line newLine = triangle.getSideAB();
        boolean expected = line.equals(newLine);
        assertTrue("Сторона АВ побудована неправильно", expected);
        line = new Line(2,2,0,4);
        newLine = triangle.getSideBC();
        expected = line.equals(newLine);
        assertTrue("Сторона BC побудована неправильно", expected);
    }
    @Test
    public void setApexC(){
        triangle.setApexC(new Point(2,2));
        Line line = new Line(3,0,2,2);
        Line newLine = triangle.getSideBC();
        boolean expected = line.equals(newLine);
        assertTrue("Сторона BC побудована неправильно", expected);
        line = new Line(2,2,0,0);
        newLine = triangle.getSideCA();
        expected = line.equals(newLine);
        assertTrue("Сторона CA побудована неправильно", expected);
    }


    @Test
    public void cloneTriangle() throws Exception {
        Triangle triangleNew = (Triangle) triangle.clone();
        boolean expected = triangle.equals(triangleNew);
        boolean  actual= true;
        assertEquals("Трикутник зклоновано неправильно", expected, actual);
        actual = triangle==triangleNew;
        expected = false;
        assertEquals("Трикутник скопійовано, а не зклоновано", expected, actual);
    }
}