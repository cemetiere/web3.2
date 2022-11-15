package beans;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import interfaces.AbstractFigure;
import interfaces.FigureVisitor;
import utils.Circle;
import utils.Rectangle;
import utils.Triangle;


/**
 *  Collects all figures and accepts visitor to each of them
 */

@RequestScoped
@Named("FigureCollector")
public class FigureCollector implements AbstractFigure, Serializable {
    AbstractFigure[] figures;
    public FigureCollector(){
        this.figures = new AbstractFigure[]{
            new Circle(),
            new Rectangle(),
            new Triangle()
        };
    }

    @Override
    public boolean accept(FigureVisitor visitor) {
        return List.of(figures).stream().anyMatch(figure -> figure.accept(visitor)==true);
    }
    
}
