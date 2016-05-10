import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class Jsonparse {
    private String city;
    private String name;
    private String base;
    private JSONObject coord;
    private JSONObject main1;
    private JSONObject wind;
    private JSONObject clouds;
    private JSONObject sys;
    private JSONArray weatherList;
    private Object main_inf;
    private Object description;

    Jsonparse(String city){
        this.city = city;
        weatherdata(city);
    }
    private void weatherdata(String city) {
        JSONParser parser = new JSONParser();
        Jsonweb test2 = new Jsonweb(city);
        String linn = test2.getData();

            try {
                Object obj = parser.parse(linn);
                JSONObject jsonObject = (JSONObject) obj;

                name = (String) jsonObject.get("name");
                //base = (String) jsonObject.get("base");
                //long id = (long) jsonObject.get("id");
                //long cod = (long) jsonObject.get("cod");
                //long dt = (long) jsonObject.get("dt");
                coord = (JSONObject) jsonObject.get("coord");
                main1 = (JSONObject) jsonObject.get("main");
                wind = (JSONObject) jsonObject.get("wind");
                clouds = (JSONObject) jsonObject.get("clouds");
                sys = (JSONObject) jsonObject.get("sys");
                weatherList = (JSONArray) jsonObject.get("weather");

                for (Object o : weatherList) {
                    JSONObject jsonLineItem = (JSONObject) o;
                    main_inf = jsonLineItem.get("main");
                    description = jsonLineItem.get("description");
                    //System.out.println(description);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    String getName(){
        return name;
    }

    String getBase(){
        return base;
    }

    Object getCoordLon(){
        return coord.get("lon");
    }

    Object getCoordLat(){
        return coord.get("lat");
    }

    Object getTemp(){
        return main1.get("temp");
    }

    Object getPressure(){
        return main1.get("pressure");
    }

    Object getHumidity(){
        return main1.get("humidity");
    }

    Object getTempMin(){
        return main1.get("temp_min");
    }

    Object getTempMax(){
        return main1.get("temp_max");
    }

    Object getWindSpeed(){
        return wind.get("speed");
    }

    Object getWindDeg(){
        return wind.get("deg");
    }

    Object getClouds(){
        return clouds.get("all");
    }

    Object getSunrise(){
        return sys.get("sunrise");
    }

    Object getSunset(){
        return sys.get("sunset");
    }

    Object getWeatherMain(){
        return main_inf;
    }

    Object getWeatherDescription(){
        return description;
    }

    // Lause on formaadis "Tuul puhub " + getWindDirection();
    String getWindDirection(){
        //double deg = (Double) getWindDeg();
        double deg = new Double(getWindDeg().toString());

        double val = (deg/45)-22.5;
        if (val<0) val = 360-val;

        ArrayList<String> suunad = new ArrayList<String>();
        suunad.addAll(Arrays.asList("põhjast", "kirdest", "idast", "kagust", "lõunast", "edelast", "läänest", "loodest"));

        return suunad.get((int)val%8);
    }

}
