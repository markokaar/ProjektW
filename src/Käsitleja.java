import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javax.swing.*;

class Käsitleja implements EventHandler<MouseEvent> {
    private Rectangle kast;
    private String vanalinn;
    private String uuslinn;

    public Käsitleja(Rectangle kast, String vanalinn, String uuslinn) {
        this.kast = kast;
        this.vanalinn = vanalinn;
        this.uuslinn = uuslinn;
    }

    public void setVanalinn(String vanalinn) {
        this.vanalinn = vanalinn;
    }

    public String getVanalinn(){
        return vanalinn;
    }

    public void handle(MouseEvent me) {
        if(me.getEventType() == MouseEvent.MOUSE_CLICKED) {
            setVanalinn(uuslinn);
            //System.out.println("Klikkis");
            //System.out.println(vanalinn);
            //System.out.println(uuslinn);


        }

        if(me.getEventType() == MouseEvent.MOUSE_ENTERED) {
            //kast.setFill(Color.GREEN);

            kast.setFill(Color.rgb(243, 134, 48));
            //vahejoon.setFill(Color.rgb(0,0,0));
        }
        else if(me.getEventType() == MouseEvent.MOUSE_EXITED){
            //kast.setFill(Color.GRAY);
            kast.setFill(Color.rgb(224, 228, 204));
        }


    }

}

