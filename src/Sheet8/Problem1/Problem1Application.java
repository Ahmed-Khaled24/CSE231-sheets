package Sheet8.Problem1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Problem1Application extends Application {
    private static Button ev1 = new Button("Ev1");
    private static Button ev2 = new Button("Ev2");
    private static Button ev3 = new Button("Ev3");
    private static Button ev4 = new Button("Ev4");
    private static TextField output = new TextField("Hello");

    @Override
    public void start(Stage primaryWindow){
        primaryWindow.setResizable(false);
        primaryWindow.setTitle("Problem1");
        primaryWindow.setScene(createAppScene());
        primaryWindow.show();
    }
    private Scene createAppScene(){
        output.setEditable(false);
        output.setPrefWidth(350);

        HBox topArea = new HBox(output);
        topArea.setPadding(new Insets(5));
        topArea.setPrefWidth(300);
        topArea.setAlignment(Pos.CENTER);

        HBox bottomArea = new HBox(ev1, ev2, ev3, ev4);
        bottomArea.setPadding(new Insets(5));
        bottomArea.setSpacing(5);
        bottomArea.setPrefWidth(300);
        bottomArea.setAlignment(Pos.CENTER);

        applyEvenHandlers();

        VBox mainPane = new VBox(topArea, bottomArea);
        return new Scene(mainPane);
    }

   private void  applyEvenHandlers(){
        ev1.setOnAction(new EventHandlerOuterClassEv1());
        ev2.setOnAction(new EventHandlerInnerClassEv2());
        ev3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                changeOutput("Hello3");
            }
        });
        ev4.setOnAction(e -> {
            changeOutput("Hello4");
        });
   }

   public static void changeOutput(String newOutput){
        output.setText(newOutput);
   }

   private class EventHandlerInnerClassEv2 implements EventHandler<ActionEvent>{
       @Override
       public void handle(ActionEvent actionEvent) {
        changeOutput("Hello2");
       }
   }
}
