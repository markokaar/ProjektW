import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Jsonweb {

    private String city;

    Jsonweb(String city){
        this.city = city;
    }



    String getCity(){
        return city;
    }

    // Tagastab Stringi milles on veebist saadud json andmed, mingi jama korral tagastab "error"
    String getData() {
        String andmed;
        try {
            String l = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=823bad53de621e0ddbdad4bbe1f29ad2";
            URL link = new URL(l);
            URLConnection connect = link.openConnection();
            BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));

            andmed = input.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            andmed = "error";
        }

        return andmed;
    }
}
