package utils;

import interfaces.AbstractFigure;
import interfaces.FigureVisitor;

public class Rectangle implements AbstractFigure{
    @Override
    public boolean accept(FigureVisitor visitor){
        return visitor.visit(this);
    }

}
