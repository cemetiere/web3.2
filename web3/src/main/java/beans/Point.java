package beans;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import interfaces.AbstractFigure;
import interfaces.FigureVisitor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@ApplicationScoped
@Named
public class Point implements Serializable {
    @Inject
    private FigureVisitor checker;

    @Inject
    @Named("FigureCollector")
    private AbstractFigure figureCollector;
    @Inject
    private DBManager data;
    private double x;
    private double y;
    private double r;

    public Point() {}

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void submit() {
        final long start = System.nanoTime();
        final boolean res = checkHit(x,y,r) ;

        Result result = new Result();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setHitFact(res);
        result.setCurrentTime(LocalDateTime.now());
        result.setExecutionTime(System.nanoTime() - start);
        data.addResult(result);
    }
    public boolean checkHit(double x, double y, double z){
        checker.setCoordinates(x, y, z);
        return figureCollector.accept(checker);
    }
    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}