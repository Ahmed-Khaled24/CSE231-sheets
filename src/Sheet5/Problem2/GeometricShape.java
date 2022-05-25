package Sheet5.Problem2;

import javafx.geometry.Point2D;

public abstract class GeometricShape {
    private javafx.geometry.Point2D start;

    // Protected constructor to give access only to subClasses.
    protected GeometricShape(){
        this.start = new Point2D(0, 0);
    }
    protected GeometricShape(Point2D start){
        this.start = start;
    }

    public Point2D getStart() {
        return start;
    }

    public void setStart(Point2D start) {
        this.start = start;
    }

    abstract public void draw();
}
