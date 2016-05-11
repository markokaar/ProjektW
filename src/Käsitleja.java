import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

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

    public String getUuslinn(){
        return uuslinn;
    }

    public void handle(MouseEvent me) {
        if(me.getEventType() == MouseEvent.MOUSE_CLICKED && !uuslinn.equals("Lisa linn")) {
            Main main = new Main();
            main.eemalda();
            main.aktiivneCity = uuslinn;
            main.informatsioon(uuslinn);
            Stage pea = new Stage();
            main.start(pea);
        }
        else if(me.getEventType() == MouseEvent.MOUSE_CLICKED && uuslinn.equals("Lisa linn")){
            String city = JOptionPane.showInputDialog(null, "Sisestage lisatava linna nimi. ",
                    JOptionPane.QUESTION_MESSAGE);

            Linnad l = new Linnad();
            l.lisaLinn(city);

            Main main = new Main();
            main.eemalda();
            main.aktiivneCity = city;
            main.informatsioon(city);
            Stage pea = new Stage();
            main.start(pea);
        }

        if(me.getEventType() == MouseEvent.MOUSE_ENTERED) {
            kast.setFill(Color.rgb(243, 134, 48));
            //vahejoon.setFill(Color.rgb(0,0,0));
        }
        else if(me.getEventType() == MouseEvent.MOUSE_EXITED){
            kast.setFill(Color.rgb(224, 228, 204));
        }
    }
}

