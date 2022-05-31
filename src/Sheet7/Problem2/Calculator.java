package Sheet7.Problem2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.InputMismatchException;

public class Calculator extends Application {

    // Constants.
    private final int BUTTON_FONT_SIZE = 16;
    private final int SCREEN_FONT_SIZE = 20;
    private final int PADDING_SIZE = 5;
    private final int BUTTON_WIDTH = 60;
    private final int BUTTON_HEIGHT = 60;

    // Initialize calculators buttons.
    private final Button number1Button = new Button("1");
    private final Button number2Button = new Button("2");
    private final Button number3Button = new Button("3");
    private final Button number4Button = new Button("4");
    private final Button number5Button = new Button("5");
    private final Button number6Button = new Button("6");
    private final Button number7Button = new Button("7");
    private final Button number8Button = new Button("8");
    private final Button number9Button = new Button("9");
    private final Button number0Button = new Button("0");
    private final Button plusSignButton = new Button("+");
    private final Button minusSignButton = new Button("-");
    private final Button divideSignButton = new Button("/");
    private final Button multiplySignButton = new Button("x");
    private final Button equalSignButton = new Button("=");
    private final Button dotSignButton = new Button(".");
    private final Button clearButton = new Button("C");
    private final Button deleteButton = new Button("Del");

    // Input output screen
    private final Label inputOutputScreen = new Label("");

    @Override
    public void start(Stage appMainWindow) {
        appMainWindow.setTitle("CALCULATOR");
        appMainWindow.setResizable(false);
        appMainWindow.setScene(createCalculatorScene());
        appMainWindow.show();
    }

    private Scene createCalculatorScene() {
        BorderPane mainPane = new BorderPane();
        creatMainPane(mainPane);
        return new Scene(mainPane);
    }

    private void creatMainPane(BorderPane mainPane) {
        createTopArea(mainPane);
        createCenterArea(mainPane);
        createBottomArea(mainPane);
        createRightArea(mainPane);
    }

    private void createTopArea(BorderPane mainPane) {
        StackPane topArea = new StackPane(inputOutputScreen);
        topArea.setPadding(new Insets(PADDING_SIZE * 4));
        inputOutputScreen.setFont(Font.font("Cambria math", SCREEN_FONT_SIZE));
        inputOutputScreen.setTextAlignment(TextAlignment.LEFT);

        // Integrate the area to the main pane.
        mainPane.setTop(topArea);
    }

    private void createCenterArea(BorderPane mainPane) {
        GridPane numbersArea = new GridPane();
        numbersArea.setPadding(new Insets(PADDING_SIZE));
        numbersArea.setVgap(PADDING_SIZE);
        numbersArea.setHgap(PADDING_SIZE);

        // First row.
        numbersArea.add(number1Button, 0, 0);
        numbersArea.add(number2Button, 1, 0);
        numbersArea.add(number3Button, 2, 0);
        // Second row.
        numbersArea.add(number4Button, 0, 1);
        numbersArea.add(number5Button, 1, 1);
        numbersArea.add(number6Button, 2, 1);
        // Third row.
        numbersArea.add(number7Button, 0, 2);
        numbersArea.add(number8Button, 1, 2);
        numbersArea.add(number9Button, 2, 2);
        // Forth row
        numbersArea.add(number0Button, 0, 3);
        numbersArea.add(dotSignButton, 2, 3);

        // Styling the buttons
        styleButtons(numbersArea.getChildren());
        GridPane.setColumnSpan(number0Button, 2);      // make the button take 2 columns instead of 1 columns
        number0Button.setPrefWidth(2 * BUTTON_WIDTH + PADDING_SIZE);

        // Add handlers
        addHandlers(numbersArea.getChildren(), "number");

        // Integrate the area to the main pane
        mainPane.setCenter(numbersArea);
    }

    private void createRightArea(BorderPane mainPane) {
        VBox signsArea = new VBox(plusSignButton, minusSignButton, multiplySignButton, divideSignButton);
        signsArea.setSpacing(PADDING_SIZE);
        signsArea.setPadding(new Insets(PADDING_SIZE));

        // Styling the buttons
        styleButtons(signsArea.getChildren());

        // Add handlers
        addHandlers(signsArea.getChildren(), "sign");

        // Integrate the area to the main pane
        mainPane.setRight(signsArea);
    }

    private void createBottomArea(BorderPane mainPane) {
        HBox bottomButtons = new HBox(clearButton, deleteButton, equalSignButton);
        bottomButtons.setSpacing(PADDING_SIZE);
        bottomButtons.setPadding(new Insets(PADDING_SIZE));

        // Styling the buttons
        styleButtons(bottomButtons.getChildren());
        equalSignButton.setPrefWidth(2 * (BUTTON_WIDTH + PADDING_SIZE));

        // Add handlers
        clearButton.setOnAction(e -> clearButtonHandler());
        deleteButton.setOnAction(e -> deleteButtonHandler());
        equalSignButton.setOnAction(e -> pressEqualButtonHandler());

        // Integrate the area to the main pane
        mainPane.setBottom(bottomButtons);
    }

    // Make all the buttons 50x50, cambria-math-18px font.
    private void styleButtons(ObservableList<Node> buttons) {
        for (Node n : buttons) {
            Button currentButton = (Button) n;
            currentButton.setPrefWidth(BUTTON_WIDTH);
            currentButton.setPrefHeight(BUTTON_HEIGHT);
            currentButton.setFont(Font.font("Cambria math", BUTTON_FONT_SIZE));
        }
    }

    private void addHandlers(ObservableList<Node> buttons, String buttonType) {
        for (Node n : buttons) {
            Button pressedButton = (Button) n;
            switch (buttonType) {
                case "number" ->
                    pressedButton.setOnAction(e -> numberButtonHandler(pressedButton));
                case "sign" ->
                    pressedButton.setOnAction(e -> signButtonHandler(pressedButton));
                case "equal" ->
                    pressedButton.setOnAction(e -> clearButtonHandler());
                case "Equal" ->
                    pressedButton.setOnAction(e -> pressEqualButtonHandler());
                case "delete" ->
                    pressedButton.setOnAction((e -> deleteButtonHandler()));
            }
        }
    }

    // Handlers for pressing any button.
    private void numberButtonHandler(Button pressedButton) {
        inputOutputScreen.setText(inputOutputScreen.getText() + pressedButton.getText());
    }

    private void signButtonHandler(Button pressedButton) {
        inputOutputScreen.setText(inputOutputScreen.getText() + " " + pressedButton.getText() + " ");
    }

    private void clearButtonHandler() {
        inputOutputScreen.setText("");
    }

    private void deleteButtonHandler() {
        char[] currentChars = inputOutputScreen.getText().toCharArray();
        String newOutput = String.copyValueOf(currentChars, 0,  currentChars.length-1 );
        inputOutputScreen.setText(newOutput);
    }

    private void pressEqualButtonHandler() {
        double firstOperand;
        double secondOperand;
        double result;
        char operation;
        String[] operationData = inputOutputScreen.getText().split(" ");

            try{
                secondOperand = Double.parseDouble(operationData[2]);
                firstOperand = Double.parseDouble(operationData[0]);
                operation = operationData[1].charAt(0);

                result = switch(operation){
                    case '+' -> result = firstOperand + secondOperand;
                    case '-' -> result = firstOperand - secondOperand;
                    case '/' -> result = firstOperand / secondOperand;
                    case 'x' -> result = firstOperand * secondOperand;
                    default -> result = handleInvalidOperation();
                };
                inputOutputScreen.setText(result + "");

            } catch (InputMismatchException | IndexOutOfBoundsException e){
                handleInvalidOperation();
            }
    }

    private double handleInvalidOperation(){
        Label invalidOperationMessage = new Label("Invalid Operation\ncheck you operands.");
        invalidOperationMessage.setStyle("-fx-font-size: 20; -fx-font-family: 'clibrie' ; -fx-padding: 50; -fx-text-alignment: center");

        StackPane invalidOperationPane = new StackPane(invalidOperationMessage);
        Scene invalidOperationScene = new Scene(invalidOperationPane);

        Stage invalidOperationWindow = new Stage();
        invalidOperationWindow.setScene(invalidOperationScene);
        invalidOperationWindow.setResizable(false);
        invalidOperationWindow.setTitle("error");
        invalidOperationWindow.show();

        return -1;
    }
}
