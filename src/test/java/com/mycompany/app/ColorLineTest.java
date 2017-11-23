package com.mycompany.app;

import com.mycompany.app.Model.ColorLine;
import com.mycompany.app.Model.ColorPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorLineTest {
    private static ColorPoint a;
    private static ColorPoint b;
    private static ColorLine line1;
    private static ColorLine line2;
    private static ColorLine line3;

    @Before
    public void init(){
        a = new ColorPoint(0,0, 5);
        b = new ColorPoint(7,7,5);
        line1 = new ColorLine(a,b,5);
        //line2 = new ColorLine(0,0,7,7);
        //line3 = new ColorLine(0,1,7,7);
    }
    @After
    public void destroy(){
        a = null;
        b = null;
        line1 = null;
        //line2 = null;
        //line3 = null;
    }
/*    @Test(expected = IllegalArgumentException.class)
    public void createLineWithWrongColor() throws Exception {
        ColorLine line = new ColorLine(a, b, 5);
        int expected = line.getColor();
        int actual = 5;
        assertEquals("Помилка задання кольору", expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setWrongColor() throws Exception {
        ColorLine line = new ColorLine(1,2,3,4,5);
        line.setColor(-1);
    }

    @Test
    public void setColor() throws Exception {
        ColorLine line = new ColorLine(1,2,3,4,5);
        int result = line.getColor();
        int expected = 5;
        assertEquals("Помилка задання кольору", result,expected);
    }*/
}