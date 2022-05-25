package Sheet5.Problem3;

import Sheet5.Problem2.GeometricShape;
import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Canvas {
    private ArrayList<GeometricShape> shapes;
    public Canvas(){
        this.shapes = new ArrayList<>();
    }

    public ArrayList<GeometricShape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<GeometricShape> shapes) {
        this.shapes = shapes;
    }

    public void addShape(GeometricShape shape){
        this.shapes.add(shape);
    }

    public void removeShape(GeometricShape shape){
        this.shapes.remove(shape);
    }

    public GeometricShape getClosestShape(Point2D givenPoint){
        GeometricShape answer = null;
        double closestDistance = Double.MAX_VALUE;

        for(GeometricShape shape: this.shapes){
            double distance = shape.getStart().distance(givenPoint);
            if(distance < closestDistance){
                closestDistance = distance;
                answer = shape;
            }
        }
        return answer;
    }

    public void drawAll(){
        for(GeometricShape shape : this.shapes){
            shape.draw();
        }
    }
}
