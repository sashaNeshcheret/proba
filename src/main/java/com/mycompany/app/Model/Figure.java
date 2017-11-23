package com.mycompany.app.Model;

public abstract class Figure extends Object implements Cloneable{
    private String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;
    }
    @Override
    protected Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public boolean equals(Figure fig){
        if(this == fig){
            return true;
        }
        if(this.getClass().getName() == fig.getClass().getName()){
            if(this.name == fig.getName()){
                return true;
            }
        }
        return false;
    }
}
