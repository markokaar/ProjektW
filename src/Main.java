
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.util.*;

public class Main extends Application{
    List<Rectangle> kastid;
    List<Rectangle> jooned;
    List<String> linnad;
    Text textMenuCity;
    String city;
    public String aktiivneCity = "";
    String fontName = "file:resources/fonts/TitilliumWeb-Bold.ttf";
    String fontName2 = "file:resources/fonts/TitilliumWeb-Light.ttf";
    Group juur = new Group();

    public Main() {
    }

    public void küljeRuudud(){

        List<Rectangle> kastid = new ArrayList<Rectangle>();
        List<Rectangle> jooned = new ArrayList<Rectangle>();
        //List<String> linnad = new ArrayList<String>();

        Linnad l = new Linnad();
        linnad = l.loeAndmed();
        int linnadeArv = linnad.size()-1;

        for(int n=0; n<=linnadeArv; n++){
            Rectangle kast1 = new Rectangle(0, n*30, 150, 30);
            kast1.setFill(Color.rgb(224, 228, 204));
            Rectangle vahejoon = new Rectangle(0, (n*30)+ 28, 150, 2);
            vahejoon.setFill(Color.rgb(0,0,0));
            kastid.add(kast1);
            //jooned.add(vahejoon);

            juur.getChildren().add(kast1);
            juur.getChildren().add(vahejoon);

            Text textMenuCity = new Text();
            textMenuCity.setText(linnad.get(n));
            textMenuCity.setFont(Font.loadFont(fontName2, 18));
            textMenuCity.setX(10);
            textMenuCity.setY(((n+1)*30)-10);
            juur.getChildren().add(textMenuCity);
        }
        Button LinnaNupp = new Button("Kustuta linn");
        LinnaNupp.setLayoutX(655);
        LinnaNupp.setLayoutY(15);
        juur.getChildren().add(LinnaNupp);

        if(linnadeArv < 9) {
            Rectangle kast3 = new Rectangle(0, (linnadeArv+1)*30, 150, 30);
            kast3.setFill(Color.rgb(224, 228, 204));
            Rectangle vahejoon = new Rectangle(0, ((linnadeArv+2)*30)+ 28, 150, 2);
            vahejoon.setFill(Color.rgb(0,0,0));
            kastid.add(kast3);
            juur.getChildren().add(kast3);


            Text textAddCity = new Text();
            textAddCity.setText("Lisa linn");
            textAddCity.setFont(Font.loadFont(fontName, 18));
            textAddCity.setX(40);
            textAddCity.setY(((linnadeArv + 2) * 30) - 10);
            juur.getChildren().add(textAddCity);
            linnad.add(textAddCity.getText());
        }

            int lugeja = 0;
            for (Rectangle kast1 : kastid) {
                Käsitleja k = new Käsitleja(kast1, aktiivneCity, linnad.get(lugeja));
                kast1.setOnMouseEntered(k);
                kast1.setOnMouseExited(k);
                kast1.setOnMouseClicked(k);

                lugeja += 1;
          }
    }


    public void informatsioon(String aktiivneCity){
        Jsonparse andmed = new Jsonparse(aktiivneCity);

        // Linna nimi - "Tartu"
        Text textCity = new Text();
        textCity.setText(andmed.getName());
        //textCity.setFont(javafx.scene.text.Font.font("Tahoma", 36));
        textCity.setFont(Font.loadFont(fontName, 36));
        textCity.setX(200);
        textCity.setY(50);
        juur.getChildren().add(textCity);
        //System.out.println(andmed.getName());
        // Weather description "Mostly Sunny"
        Text textWeatherDesc = new Text();
        textWeatherDesc.setText(andmed.getWeatherDescription().toString());
        textWeatherDesc.setFont(Font.loadFont(fontName2, 18));
        textWeatherDesc.setX(200);
        textWeatherDesc.setY(80);
        juur.getChildren().add(textWeatherDesc);

        String kirjeldus = andmed.getWeatherDescription().toString();
        Map<String, Image> ikoon = new HashMap<String, Image>();
        Ikoonid ikoonid = new Ikoonid(ikoon);
        Image image = ikoonid.terminidpäeval(ikoon).get(kirjeldus);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setX(200);
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
            textA.setX(200);
            textA.setY(230 + lugeja);
            juur.getChildren().add(textA);

            lugeja += 20;
        }
    }
    public void eemalda(){
        juur.getChildren().clear();
    }
    @Override
    public void start(Stage peaLava){
        // Akna suurust muuta ei saa ja akna servad on eemaldatud.
        peaLava.setTitle("Projekt W");
        peaLava.setResizable(false);
        //peaLava.initStyle(StageStyle.UTILITY);

        Canvas lõuend = new Canvas(750, 460);
        GraphicsContext gc = lõuend.getGraphicsContext2D();

        // Background
        gc.setFill(Color.rgb(167, 219, 216));
        gc.fillRect(0, 0, 800, 600);
        // Linnade kast
        gc.setFill(Color.rgb(105, 210, 231));
        gc.fillRect(0, 0, 150, 600);
        gc.setFill(Color.rgb(0, 0, 0));
        gc.fillRect(150, 0, 2, 600);

        juur.getChildren().add(lõuend);


        ////////////////////////////////
        // Text and information stuff //
        ////////////////////////////////
        int o = 0;
        while (o < 1) {
            informatsioon(aktiivneCity);
            o++;
        }
        küljeRuudud();


        Scene stseen = new Scene(juur);
        peaLava.setScene(stseen);
        peaLava.show();
    }

    public static void main(String[] args){
        // Mis piirkonna kohta on infot vaja?
        /*String city = JOptionPane.showInputDialog(null, "Mis piirkonna kohta infot on vaja? \n" +
                "Suvalise asukoha korral jäta lahter tühjaks või vajuta cancel.", "Asukoht",
                JOptionPane.QUESTION_MESSAGE);
*/

        launch(args);
    }
}


