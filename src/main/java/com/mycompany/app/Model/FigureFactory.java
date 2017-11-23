package com.mycompany.app.Model;

public class FigureFactory {
    public static Figure[] createList(int arg){
        Figure[] array = generateRandom(arg);
        return array;
    }
    public static Figure[] generateRandom (int n) {
        Figure[] array = new Figure[n];
        for (int j = 0; j < n; j++) {
            int i = (int) (Math.random() * 6);
            Figure temp = generate(i);
            array[j] = temp;
        }
        return array;
    }

    public static Figure generate(int i){
        switch(i){
            case 0: return generPoint();
            case 1: return generColorPoint();
            case 2: return new Line(generPoint(), generPoint());
            case 3: return new ColorLine(generColorPoint(), generColorPoint(), (int) (Math.random()*256));
            case 4: return new Triangle("Triangle",generPoint(), generPoint(), generPoint());
            case 5: return new ColorTriangle("Color Triangle", generPoint(), generPoint(),
                                             generPoint(), (int) (Math.random()*256));
            case 6: return new Polygon("Polygon", generPoint(), generPoint(), generPoint(),
                                             generPoint(), generPoint());
            case 7: return new Polygon("Polygon2", generPoint(), generPoint(), generPoint(),
                                              generPoint(), generPoint(), generPoint());
            default: return null;
        }
    }
    public static Point generPoint(){
        return new Point((int) (Math.random()*10), (int)(Math.random()*10));
    }

    public static ColorPoint generColorPoint(){
        return new ColorPoint((int) (Math.random()*10), (int)(Math.random()*10),(int) (Math.random()*256));
    }


}
