package com.mycompany.app;

import com.mycompany.app.Model.*;

/**
 * Created by Нещерет on 22.11.2017.
 */
public class Control {
    public static Figure[][] sort(Figure[] arrayFig){
        int color = 0;
        int withOutColor = 0;
        Figure[][] figure = new Figure[2][arrayFig.length];
        for(Figure fig : arrayFig) {
            if(fig instanceof Colorable){
                figure[0][color++] = fig;
            }else{
                figure[1][withOutColor++] = fig;
            }
        }
        return figure;
    }

    public static Figure[][] sortArray(Figure[] array){
        int numPoint = 0;
        int numLine = 0;
        int numTriangle = 0;
        Figure[][] figure = new Figure[3][array.length];
        for(Figure fig : array) {
            if(fig instanceof Point){
                figure[0][numPoint++] = fig;
            }
            if(fig instanceof Line){
                figure[1][numLine++] = fig;
            }
            if(fig instanceof Triangle){
                figure[2][numTriangle++] = fig;
            }
        }
        return figure;
    }
    public static Figure[][] sortColorArray(Figure[] arrayColor){
        int numColorPoint = 0;
        int numColorLine  = 0;
        int numColorTriangle = 0;
        Figure[][] figure = new Figure[3][arrayColor.length];
        for(Figure fig : arrayColor) {
            if(fig instanceof Point){
                figure[0][numColorPoint++] = fig;
            }
            if(fig instanceof Line){
                figure[1][numColorLine++] = fig;
            }
            if(fig instanceof Triangle){
                figure[2][numColorTriangle++] = fig;
            }
        }
        return figure;
    }
    public static int numColorFigure(Figure[] colorFigure){
        int numColorFigure = 0;
        for(Figure fig : colorFigure) {
            if (fig != null) {
                System.out.println(fig);
                numColorFigure++;
            }
        }
        return numColorFigure;
    }

    public static int numFigure(Figure[] figure){
        int numFigure = 0;
        for(Figure fig : figure) {
            if (fig != null) {
                System.out.println(fig);
                numFigure++;
            }
        }
        return numFigure;
    }
}
