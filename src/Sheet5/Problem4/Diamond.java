package Sheet5.Problem4;

import Sheet5.Problem2.GeometricShape;
import javafx.geometry.Point2D;

public class Diamond  extends GeometricShape implements Movable, Comparable<Diamond> {
    private double length, width;
    public Diamond(Point2D start, double length, double width){
        super(start);
        this.length = length;
        this.width = width;
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

    public double getArea(){
        return 0.5 * length * width;
    }

    @Override
    public void draw() {
        System.out.println(
                "\nThis shape is: Diamond"+
                "\nStart point: " + this.getStart()+
                "\nLength: " + this.length +
                "\nWidth: " + this.width +
                "\nArea: " + getArea()
        );
    }

    @Override
    public void move(double dx, double dy) {
           setStart(new Point2D(getStart().getX() + dx, getStart().getY() + dy));
    }


    @Override
    public int compareTo(Diamond otherDiamond) {
        double thisDiamondArea = getArea(),
               otherDiamondArea = otherDiamond.getArea();
        if(thisDiamondArea == otherDiamondArea)
            return 0;
        else if (thisDiamondArea < otherDiamondArea)
            return -1;
        else
            return 1;
    }

}
