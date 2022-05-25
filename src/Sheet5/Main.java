package Sheet5;

import Sheet5.Problem2.Ellipse;
import Sheet5.Problem2.Line;
import Sheet5.Problem2.Rectangle;
import Sheet5.Problem3.Canvas;
import Sheet5.Problem4.Diamond;
import Sheet5.Problem5.Problem5;
import javafx.geometry.Point2D;

public class Main {
    public static void main(String[] args) {
        testProblem5();
    }

    // Problems' tests
    private static void testProblem2(){
        Line line = new Line(new Point2D(0,0), new Point2D(0, 50));
        line.draw();

        Rectangle rectangle = new Rectangle(new Point2D(0,0), 10, 15);
        rectangle.draw();

        Ellipse ellipse = new Ellipse(new Point2D(0, 0), 10, 10);
        ellipse.draw();
    }
    private static void testProblem3(){
        Canvas canvas = new Canvas();
        Line line = new Line(new Point2D(1,1), new Point2D(0, 50));
        Rectangle rectangle = new Rectangle(new Point2D(2,2), 10, 15);
        Ellipse ellipse = new Ellipse(new Point2D(3, 3), 10, 10);

        canvas.addShape(line);
        canvas.addShape(rectangle);
        canvas.addShape(ellipse);

        Line lineToBeRemoved = new Line(new Point2D(0,0), new Point2D(0, 50));
        canvas.addShape(lineToBeRemoved);
        canvas.getClosestShape(new Point2D(0, 0)).draw();   // Should print shape: lineToBeRemoved
        canvas.removeShape(lineToBeRemoved);
        canvas.getClosestShape(new Point2D(0, 0)).draw();   // Should print shape: line

        System.out.println("\n\n\n");
        canvas.drawAll();
    }
    private static void testProblem4(){
        Diamond smallDiamond = new Diamond(new Point2D(0, 0), 10, 10);
        Diamond bigDiamond = new Diamond(new Point2D(0, 0), 20, 20);

        // Before moving
        smallDiamond.draw();
        bigDiamond.draw();

        smallDiamond.move(1, 1);
        bigDiamond.move(2,2);

        // After moving
        smallDiamond.draw();
        bigDiamond.draw();

        System.out.println(
                "1 means first is bigger than second, -1 is the inverse, and 0 means equals: " +
                bigDiamond.compareTo(smallDiamond)
        );
        System.out.println(
                "1 means first is bigger than second, -1 is the inverse, and 0 means equals: " +
                        smallDiamond.compareTo(bigDiamond)
        );
        System.out.println(
                "1 means first is bigger than second, -1 is the inverse, and 0 means equals: " +
                        smallDiamond.compareTo(smallDiamond)
        );

    }
    private static void testProblem5(){
        Problem5.problem5Implementation();
    }

}
