package Sheet5.Problem2;

import javafx.geometry.Point2D;

public class Rectangle extends GeometricShape {
    private double length, width;
    public Rectangle(Point2D start, double length, double width){
        super(start);
        this.length = length;
        this.width = width;
    }
    public  Rectangle(){
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
                "This shape is: Rectangle" +
                "\nStart point: " + this.getStart() +
                "\nLength: " + this.getLength() +
                "\nWidth: " + this.getWidth()
        );
    }

    // For problem 3
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Rectangle otherRectangle)
            return this.getStart().equals(otherRectangle.getStart()) &&
                   this.getLength() == otherRectangle.getLength() &&
                   this.getWidth() == otherRectangle.getWidth();

        return false;
    }
}
