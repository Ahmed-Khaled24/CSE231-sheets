package Sheet3;
import javafx.geometry.Point2D;

public class Line {
    private Vector vector;
    private Point2D point;

    public Line(Vector vector, Point2D point) {
        this.vector = vector;
        this.point = point;
    }

    public Line( double vectorX, double vectorY, double pointX, double pointY){
        this(new Vector(vectorX,vectorX), new Point2D(pointX, pointY));
    }

    public void print(){
        // print the position [the 2d point]
        System.out.println("Position: (" + point.getX() + ", " + point.getY() + ")");
        // print the direction [2d vector]
        System.out.println("Direction: " +  String.format("%.2f", vector.angle()));


    }


}
