package beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import interfaces.FigureVisitor;
import jakarta.ejb.DependsOn;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import utils.Circle;
import utils.Rectangle;
import utils.Triangle;

import java.io.Serializable;

/**
 * Figure visitor that checks hits.
 */

@SessionScoped
@Named("checker")
public class Checker implements FigureVisitor, Serializable {
    private double x;
    private double y;
    private double r;
    @Override
    public void setCoordinates(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
    @Override
    public boolean visit(Circle circle) {
        double rr = Math.sqrt(x*x+y*y);
        boolean result = x<=0 && y>=0 && rr<=((double)r);
        return result;
    }
    @Override
    public boolean visit(Rectangle rectangle) {
        return x>=0 && y>=0 && y<=((double)r) && x<=((double)r)/2;
    }
    @Override
    public boolean visit(Triangle triangle) {
        return x<=0 && y<=0 && y>=(-x-r/2);
    }
    @Override
    public boolean visit(FigureCollector figureCollector) {
        return true;
    }
}
