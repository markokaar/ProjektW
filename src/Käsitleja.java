import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Käsitleja implements EventHandler<MouseEvent> {
    private Rectangle kast;

    public Käsitleja(Rectangle kast) {
        this.kast = kast;
    }

    public void handle(MouseEvent me) {
        if(me.getEventType() == MouseEvent.MOUSE_ENTERED) {
            //kast.setFill(Color.GREEN);

            kast.setFill(Color.rgb(243, 134, 48));
            //vahejoon.setFill(Color.rgb(0,0,0));
        }
        else{
            //kast.setFill(Color.GRAY);
            kast.setFill(Color.rgb(224, 228, 204));
        }
    }
}
