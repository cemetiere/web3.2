package interfaces;

@FunctionalInterface
public interface AbstractFigure {
    public boolean accept(FigureVisitor visitor);
}
