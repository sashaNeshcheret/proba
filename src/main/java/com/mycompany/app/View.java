package com.mycompany.app;

import com.mycompany.app.Model.Figure;
import com.mycompany.app.Model.FigureFactory;

import static com.mycompany.app.MainClass.listFigure;

/**
 * Created by Нещерет on 22.11.2017.
 */
public class View {

    public static void printOutFigures(Figure[] figure) {
        for(Figure fig : figure) {
            if(fig != null)System.out.println(fig);
        }
    }
    public static void printCreate() {
        System.out.println("Генеруємо " + listFigure.length + " фігур застосовуючи " + FigureFactory.class + " : \n");
    }
    public static void printOut1() {
        System.out.println("Виводимо всі фігури з сформованого списку\n");
    }

    public static void printFiguresGroupByClass(){
        System.out.println("Виводимо інформацію про фігури в кожній групі\n");

    }
}
