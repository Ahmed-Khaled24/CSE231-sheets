package Sheet5.Problem2;

import javafx.geometry.Point2D;

public final class Ellipse extends GeometricShape{
    private double length, width;
    public Ellipse(Point2D start, double length, double width){
        super(start);
        this.length = length;
        this.width = width;
    }
    public  Ellipse(){
        this(new Point2D(0, 0), 0.0, 0.0);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void draw(){
        System.out.println(
                "This shape is: Ellipse" +
                        "\nStart point: " + this.getStart() +
                        "\nLength: " + this.getLength() +
                        "\nWidth: " + this.getWidth()
        );
    }

    // For problem 3
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ellipse otherEllipse)
            return this.getStart().equals(otherEllipse.getStart()) &&
                    this.length == otherEllipse.getLength() &&
                    this.width == otherEllipse.getWidth();
        return false;
    }
}
