package Sheet8.Problem2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

public class Problem2Application extends Application {
    private final static int APP_WIDTH = 500;
    private final static int APP_HEIGHT = 500;
    private final static int MOVE_DISTANCE = 10;

    @Override
    public void start(Stage primaryWindow) {
        primaryWindow.setTitle("Mouse and key events");
        primaryWindow.setScene(createAppScene());
        primaryWindow.setResizable(false);
        primaryWindow.show();
    }
    private Scene createAppScene(){
        Pane mainArea = new Pane();
        mainArea.setPrefWidth(APP_WIDTH);
        mainArea.setPrefHeight(APP_HEIGHT);
        applyHandlers(mainArea);
        return new Scene(mainArea);
    }

    private void applyHandlers(Pane mainArea){
        // Handle mouse enter the app.
        mainArea.setOnMouseEntered(enterEvent -> {
            mainArea.requestFocus();
            mainArea.getChildren().add(generateRandomCircle());
            System.out.println("mouse enter");

            // Handle mouse drag a circle.
            for(Node n : mainArea.getChildren()){
                Circle c = (Circle) n;
                c.setOnMouseDragged(dragEvent -> {
                    c.setCenterY(dragEvent.getY());
                    c.setCenterX(dragEvent.getX());
                });
            }
        });

        // Handle arrow keys.
        mainArea.setOnKeyPressed( keyPressed -> {
            System.out.println("Key pressed");
            switch (keyPressed.getCode()) {
                case UP -> {
                    System.out.println("Up arrow pressed");
                    moveCirclesUp(mainArea);
                }
                case DOWN -> {
                    System.out.println("Down arrow pressed");
                    moveCirclesDown(mainArea);
                }
                case LEFT -> {
                    System.out.println("Left arrow pressed");
                    moveCirclesLeft(mainArea);
                }
                case RIGHT -> {
                    System.out.println("Right arrow pressed");
                    moveCirclesRight(mainArea);
                }
                default -> System.out.println("No arrow pressed");
            }
        });


    }
    private void moveCirclesUp(Pane mainArea){
        for(Node n: mainArea.getChildren()){
            Circle c = (Circle) n;
            c.setCenterY(c.getCenterY() - MOVE_DISTANCE);
        }
    }

    private void moveCirclesDown(Pane mainArea){
        for(Node n: mainArea.getChildren()){
            Circle c = (Circle) n;
            c.setCenterY(c.getCenterY() + MOVE_DISTANCE);
        }
    }

    private void moveCirclesLeft(Pane mainArea){
        for(Node n: mainArea.getChildren()){
            Circle c = (Circle)n;
            c.setCenterX(c.getCenterX() - MOVE_DISTANCE);
        }
    }

    private void moveCirclesRight(Pane mainArea){
        for(Node n: mainArea.getChildren()){
            Circle c = (Circle)n;
            c.setCenterX(c.getCenterX() + MOVE_DISTANCE);
        }
    }

    private Circle generateRandomCircle(){
        Random randomGenerator = new Random();
        int upperBoundRadius = 50;
        int radius = randomGenerator.nextInt(upperBoundRadius);
        int upperBoundLocation = APP_WIDTH - upperBoundRadius;
        int locationX = randomGenerator.nextInt(upperBoundLocation);
        int locationY = randomGenerator.nextInt(upperBoundLocation);

        return new Circle(locationX, locationY, radius,  new Color(randomGenerator.nextDouble(),
                randomGenerator.nextDouble(), randomGenerator.nextDouble(), 1));
    }
}
