package Sheet8.Problem1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventHandlerOuterClassEv1 implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        Problem1Application.changeOutput("Hello1");
    }
}
