import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args){
        JSONParser parser = new JSONParser();
        Jsonweb test2 = new Jsonweb("Tartu");
        String linn = test2.getData();


        try {

            //String object = String.parseString(linn_andmed);

            Object obj = parser.parse(linn);

            JSONObject jsonObject = (JSONObject) obj;

            String name = (String) jsonObject.get("name");
            String base = (String) jsonObject.get("base");
            //long id = (long) jsonObject.get("id");
            //long cod = (long) jsonObject.get("cod");
            //long dt = (long) jsonObject.get("dt");
            JSONObject coord = (JSONObject) jsonObject.get("coord");
            JSONObject main = (JSONObject) jsonObject.get("Main");
            JSONObject wind = (JSONObject) jsonObject.get("wind");
            JSONObject clouds = (JSONObject) jsonObject.get("clouds");
            JSONObject sys = (JSONObject) jsonObject.get("sys");
            JSONArray weatherList = (JSONArray) jsonObject.get("weather");


            //return "Name: " + name;


            System.out.println("base: " + base);
            //System.out.println("id: " + id);
            //System.out.println("cod: " + cod);
            //System.out.println("dt: " + dt);
            //System.out.println("wind: " + wind);
            //System.out.println("Main: " + Main);
            //System.out.println("clouds: " + clouds);
            //System.out.println("sys: " + sys);
            //System.out.println("Coord: " + coord);
            //System.out.println("Main: temp: " + Main.get("temp"));
            //System.out.println("weatherList:");
            //Iterator<JSONObject> iterator = weatherList.iterator();
            //while (iterator.hasNext()) {
            //    System.out.println(iterator.next());
            //}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

