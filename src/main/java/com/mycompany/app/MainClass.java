package com.mycompany.app;

import com.mycompany.app.Model.Figure;
import com.mycompany.app.Model.FigureFactory;

import static com.mycompany.app.View.*;

public class MainClass {
    public static Figure[] listFigure;

    public static void main(String[] args) {

        /*
        *  1. создать последовательность из фигур  используя фабрики цветных и нецветных фигур
        *  2. получить масивы цветных и не цветных и сколько каждых фигур в нем присутсвует
        *  3. групируем в масивах фигуры
        */
        listFigure = FigureFactory.createList(20);
        printCreate();
        printOutFigures(listFigure);
        Figure[][] array = Control.sort(listFigure);
        Figure[] colorFigure = array[0];
        Figure[] figure = array[1];
        printOut1();
        printFiguresGroupByClass();
        /*System.out.println("Кольорові фігури");
        printOutFigures(colorFigure);
        System.out.println("Некольорові фігури");
        printOutFigures(figure);*/
        int mumColor = Control.numColorFigure(colorFigure);
        int mum = Control.numFigure(figure);
        System.out.println("Кількість кольорових фігур: " + mumColor);
        System.out.println("Кількість некольорових фігур: " + mum);
/*
        Figure[] point, line, triangle;
        Figure[] pointColor, lineColor, triangleColor;
        pointColor =  FigureFactory.sortColorArray(colorFigure)[0];
        lineColor  =  FigureFactory.sortColorArray(colorFigure)[1];
        triangleColor = FigureFactory.sortColorArray(colorFigure)[2];

        point = FigureFactory.sortArray(figure)[0];
        line = FigureFactory.sortArray(figure)[1];
        triangle = FigureFactory.sortArray(figure)[2];
        System.out.println(pointColor);
        System.out.println(lineColor);
        System.out.println(triangleColor);

        System.out.println(point);
        System.out.println(line);
        System.out.println(triangle);*/
    }
}
