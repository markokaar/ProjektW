import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args){
        // Mis piirkonna kohta on infot vaja?
        String city = JOptionPane.showInputDialog(null, "Mis piirkonna kohta infot on vaja? \n" +
                "Suvalise linna korral jäta lahter tühjaks või vajuta cancel.", "Asukoht",
                JOptionPane.QUESTION_MESSAGE);

        // Kui vajutab cancel
        if (city == null) {
            city = "";
        }

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
        System.out.println("\tValgust on meil täna " + daylight_time.getHours() + " tundi, "
                + daylight_time.getMinutes() + " minutit ja " + daylight_time.getSeconds() + " sekundit.");

    }
}

