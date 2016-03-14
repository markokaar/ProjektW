import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class main {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    "C:/Users/Ako oma/Documents/json2.txt"));

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String base = (String) jsonObject.get("base");
            //long id = (long) jsonObject.get("id");
            //long cod = (long) jsonObject.get("cod");
            //long dt = (long) jsonObject.get("dt");
            JSONObject coord = (JSONObject) jsonObject.get("coord");
            JSONObject main = (JSONObject) jsonObject.get("main");
            JSONObject wind = (JSONObject) jsonObject.get("wind");
            JSONObject clouds = (JSONObject) jsonObject.get("clouds");
            JSONObject sys = (JSONObject) jsonObject.get("sys");
            JSONArray weatherList = (JSONArray) jsonObject.get("weather");

            System.out.println("Name: " + name);
            System.out.println("base: " + base);
            //System.out.println("id: " + id);
            //System.out.println("cod: " + cod);
            //System.out.println("dt: " + dt);
            System.out.println("wind: " + wind);
            System.out.println("main: " + main);
            System.out.println("clouds: " + clouds);
            System.out.println("sys: " + sys);
            System.out.println("Coord: " + coord);
            System.out.println("main: temp: " + main.get("temp"));
            System.out.println("weatherList:");
            Iterator<JSONObject> iterator = weatherList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
