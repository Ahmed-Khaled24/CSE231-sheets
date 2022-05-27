package Sheet7.Problem1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Pb1Application extends Application {
    private static final double SCENE_HEIGHT = 500;
    private static final double SCENE_WIDTH = 500;
    private static final double PADDING = 15;
    @Override
    public void start(Stage pb1Stage){

        // Red circle
        Circle redCircle = new Circle(40);
        redCircle.setStyle("-fx-fill: red; -fx-stroke: black; -fx-stroke-width: 3");
        redCircle.setCenterX(redCircle.getRadius() + PADDING);
        redCircle.setCenterY(redCircle.getRadius() + PADDING);
        // Circle Label
        Label circleLabel = new Label("Circle");
        circleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: red");
        circleLabel.setLayoutX(redCircle.getCenterX() + 50);
        circleLabel.setLayoutY(redCircle.getCenterY() - 20);

        // Green rectangle
        Rectangle greenRectangle = new Rectangle(80, 80);
        greenRectangle.setStyle("-fx-fill: green; -fx-stroke: black; -fx-stroke-width: 3");
        greenRectangle.setX(SCENE_WIDTH - greenRectangle.getWidth() - PADDING*2);
        greenRectangle.setY(SCENE_HEIGHT - greenRectangle.getHeight() - PADDING*2);
        greenRectangle.setRotate(45);
        // Rectangle label
        Label rectangleLabel = new Label("Rotated\nRectangle");
        rectangleLabel.setStyle("-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: green");
        rectangleLabel.setLayoutX(SCENE_WIDTH - 220);
        rectangleLabel.setLayoutY(SCENE_HEIGHT - 100);

        // Line
        Line connectionLine = new Line(redCircle.getCenterX(), redCircle.getCenterY(),
                greenRectangle.getX() + 40, greenRectangle.getY() + 40);
        connectionLine.setStyle("-fx-stroke-width: 3; -fx-stroke: black");

        Pane pb1Pane = new Pane(redCircle, circleLabel, greenRectangle, rectangleLabel, connectionLine);
        pb1Pane.setStyle("-fx-border-width: 5; -fx-border-color: black; -fx-stroke-line-join: round");

        Scene pb1Scene = new Scene(pb1Pane, SCENE_HEIGHT, SCENE_WIDTH);

        pb1Stage.setTitle("Pb1");
        pb1Stage.setScene(pb1Scene);
        pb1Stage.setResizable(false);
        pb1Stage.show();
    }


}
