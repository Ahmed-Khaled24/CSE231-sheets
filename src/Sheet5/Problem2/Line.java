package Sheet5.Problem2;

import javafx.geometry.Point2D;

public final class Line extends GeometricShape {
    private javafx.geometry.Point2D end;

    public Line(Point2D start, Point2D end){
        super(start);
        this.end = end;
    }

    public Line(){
    this(new Point2D(0, 0), new Point2D(0, 0));
    }

    public Point2D getEnd() {
        return end;
    }

    public void setEnd(Point2D end) {
        this.end = end;
    }

    public void draw(){
        System.out.println(
                "This shape is: Line" +
                "\nStart point: " + getStart() +
                "\nEnd point: " + getEnd()
        );
    }

    // For problem 3.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line line) {
            return this.getStart().equals(line.getStart()) &&
                   this.getEnd().equals(line.getEnd());
        }
        return false;

    }

}
