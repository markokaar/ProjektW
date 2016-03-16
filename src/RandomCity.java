import java.util.concurrent.ThreadLocalRandom;
import java.net.*;
import java.io.*;

public class RandomCity {
    private String suvalinn;
    String find() {
        try {
            int arv = ThreadLocalRandom.current().nextInt(0, 74000 + 1);

            URL linnad = new URL("http://openweathermap.org/help/city_list.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(linnad.openStream()));

            String inputLine;
            String e;
            int a = 0;
            while ((inputLine = in.readLine()) != null && a != arv) {
                a++;
                if (a == arv) {
                    suvalinn = inputLine.split("\t")[1];
                    break;
                }
            }
            in.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            suvalinn = "error";
        }

        return suvalinn;
    }
}
