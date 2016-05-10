import javax.swing.JOptionPane;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application{
    @Override
    public void start(Stage peaLava) {
        // Akna suurust muuta ei saa ja akna servad on eemaldatud.
        peaLava.setTitle("Projekt W");
        peaLava.setResizable(false);
        peaLava.initStyle(StageStyle.UTILITY);
        Group juur = new Group();
        Canvas lõuend = new Canvas(800, 600);
        GraphicsContext gc = lõuend.getGraphicsContext2D();

        // Draw shapes
        // Background
        gc.setFill(Color.rgb(167, 219, 216));
        gc.fillRect(0, 0, 800, 600);
        // Linnade kast
        gc.setFill(Color.rgb(105, 210, 231));
        gc.fillRect(0, 0, 200, 600);
        gc.setFill(Color.rgb(0, 0, 0));
        gc.fillRect(200, 0, 2, 600);


        List<Rectangle> kastid = new ArrayList<Rectangle>();
        List<Rectangle> jooned = new ArrayList<Rectangle>();
        int linnadeArv = 5;

        for(int n=0; n<=linnadeArv; n++){
            Rectangle kast1 = new Rectangle(0, n*48, 200, 48);
            kast1.setFill(Color.rgb(224, 228, 204));
            //kast1.setStroke(new BasicStroke(5.0f));
            Rectangle vahejoon = new Rectangle(0, (n*48)+ 46, 200, 2);
            vahejoon.setFill(Color.rgb(0,0,0));
            kastid.add(kast1);
            jooned.add(vahejoon);
        }

        juur.getChildren().add(lõuend);
        for(Rectangle kast : kastid){
            juur.getChildren().add(kast);
        }

        for(Rectangle joon : jooned){
            juur.getChildren().add(joon);
        }

        for(Rectangle kast1 : kastid) {
            kast1.setOnMouseEntered(new Käsitleja(kast1));
            kast1.setOnMouseExited(new Käsitleja(kast1));
            //kast1.setOnMouse
            /*
            kast1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent me) {
                    //System.out.println("Hiir läks kasti peale");
                }
            });
            */
        }



        ////////////////////////////////
        // Text and information stuff //
        ////////////////////////////////
        String city = null;

        if (city == null) {
            city = "";
        }
        Jsonparse andmed = new Jsonparse(city);

        String fontName = "file:resources/fonts/TitilliumWeb-Bold.ttf";
        String fontName2 = "file:resources/fonts/TitilliumWeb-Light.ttf";


        // Linna nimi - "Tartu"
        Text textCity = new Text();
        textCity.setText(andmed.getName());
        //textCity.setFont(javafx.scene.text.Font.font("Tahoma", 36));
        textCity.setFont(Font.loadFont(fontName, 36));
        textCity.setX(400);
        textCity.setY(50);
        juur.getChildren().add(textCity);

        // Weather description "Mostly Sunny"
        Text textWeatherDesc = new Text();
        textWeatherDesc.setText(andmed.getWeatherDescription().toString());
        textWeatherDesc.setFont(Font.loadFont(fontName2, 18));
        textWeatherDesc.setX(400);
        textWeatherDesc.setY(80);
        juur.getChildren().add(textWeatherDesc);

        Image image = new Image("file:resources/weather/clear.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(400);
        imageView.setY(100);
        juur.getChildren().add(imageView);


        List<String> andmed2 = new ArrayList<String>();
        andmed2.add(andmed.getWeatherMain().toString());
        andmed2.add("Temperatuur: " + andmed.getTemp().toString());
        andmed2.add("Tuulekiirus: " + andmed.getWindSpeed().toString());
        andmed2.add("Tuul puhub suunast " + andmed.getWindDirection() + " kiirusel " + andmed.getWindSpeed().toString() + " m/s");
        andmed2.add("Pilvisus: " + andmed.getClouds() + "%");
        andmed2.add("Õhuniiskus: " + andmed.getHumidity() + "%");
        andmed2.add("Õhurõhk: " + andmed.getPressure() + " hPa");

        // Andmed päikese kohta
        long sunrise = (Long) andmed.getSunrise();
        long sunset = (Long) andmed.getSunset();
        long daylight = sunset-sunrise;

        java.sql.Time sunrise_time=new java.sql.Time(sunrise*1000);
        java.sql.Time sunset_time=new java.sql.Time(sunset*1000);
        java.sql.Time daylight_time=new java.sql.Time(daylight*1000);

        andmed2.add("Päike tõuseb kell: " + sunrise_time + " ");
        andmed2.add("Päike loojub kell: " + sunset_time + " ");
        andmed2.add("Valgust on täna " + daylight_time.getHours() + " tundi, "
                + daylight_time.getMinutes() + " minutit ja " + daylight_time.getSeconds() + " sekundit.");


        // Käib tehtud andmed2 listi läbi ja kirjutab andmed välja (iga rea vahel 20px)
        int lugeja = 0;
        for(String a : andmed2){
            Text textA = new Text();
            textA.setText(a);
            textA.setFont(Font.loadFont(fontName2, 18));
            textA.setX(400);
            textA.setY(300 + lugeja);
            juur.getChildren().add(textA);

            lugeja += 20;
        }






        Scene stseen = new Scene(juur);
        peaLava.setScene(stseen);
        peaLava.show();


        /*
        Button LinnaNupp = new Button("Lisa linn");
        LinnaNupp.setLayoutX(75);
        LinnaNupp.setLayoutY(100);
        juur.getChildren().add(LinnaNupp);
        */

    }

    public static void main(String[] args){
        // Mis piirkonna kohta on infot vaja?
        /*String city = JOptionPane.showInputDialog(null, "Mis piirkonna kohta infot on vaja? \n" +
                "Suvalise asukoha korral jäta lahter tühjaks või vajuta cancel.", "Asukoht",
                JOptionPane.QUESTION_MESSAGE);
*/
        /*String city = null;
        // Kui vajutab cancel, siis jätab nime tühjaks ja Jsonweb otsib siis suvalise linna
        if (city == null) {
            city = "";
        }*/

        launch(args);
/*
        Jsonparse andmed = new Jsonparse(city);

        System.out.println("\t\t\t" + andmed.getName() + " - " + andmed.getWeatherDescription() + "\n");
        //System.out.println(andmed.getWeatherMain());
        System.out.println("\tTemperatuur: " + andmed.getTemp() + "°C");
        //System.out.println("\tTuulekiirus " + andmed.getWindSpeed() + " m/s");
        System.out.println("\tTuul puhub " + andmed.getWindDirection() + " kiirusel " + andmed.getWindSpeed() + " m/s. ");
        System.out.println("\tPilvisus: " + andmed.getClouds() + "%");
        System.out.println("\tÕhuniiskus: " + andmed.getHumidity() + "%");
        System.out.println("\tÕhurõhk: " + andmed.getPressure() + " hPa");

        //System.out.println("Coords " + andmed.getCoordLon() + ", " + andmed.getCoordLat());
        //System.out.println("Tuulesuund: " + andmed.getWindDeg() + " kraadi");

        // Andmed päikese kohta
        long sunrise = (Long) andmed.getSunrise();
        long sunset = (Long) andmed.getSunset();
        long daylight = sunset-sunrise;

        java.sql.Time sunrise_time=new java.sql.Time(sunrise*1000);
        java.sql.Time sunset_time=new java.sql.Time(sunset*1000);
        java.sql.Time daylight_time=new java.sql.Time(daylight*1000);

        System.out.println("\tPäike tõuseb kell: " + sunrise_time + " ");
        System.out.println("\tPäike loojub kell: " + sunset_time + " ");
        System.out.println("\tValgust on täna " + daylight_time.getHours() + " tundi, "
                + daylight_time.getMinutes() + " minutit ja " + daylight_time.getSeconds() + " sekundit.");
        */
    }
}

