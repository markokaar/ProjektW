import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class Ikoonid {
    private Map<String, Image> ikoonid;

    public Ikoonid(Map<String, Image> ikoonid) {
        this.ikoonid = ikoonid;
    }

    public Map<String, Image>  terminidpäeval(Map<String, Image> ikoonid){
        ikoonid.put("light rain", new Image("file:resources/weather/rain02.png"));
        ikoonid.put("few clouds", new Image("file:resources/weather/partlycloudy.png"));
        ikoonid.put("scattered clouds", new Image("file:resources/weather/scatteredclouds.png"));
        ikoonid.put("clear sky", new Image("file:resources/weather/clear.png"));
        ikoonid.put("overcast clouds", new Image("file:resources/weather/hazy.png"));
        ikoonid.put("broken clouds", new Image("file:resources/weather/mostlysunny.png"));
        ikoonid.put("moderate rain", new Image("file:resources/weather/rain03.png"));
        return ikoonid;


    }
    public Map<String, Image>  terminidöösel(Map<String, Image> ikoonid){
        ikoonid.put("light rain", new Image("file:resources/weather/rainnight.png"));
        ikoonid.put("few clouds", new Image("file:resources/weather/partlycloudynight.png"));
        ikoonid.put("scattered clouds", new Image("file:resources/weather/scatteredclouds.png"));
        ikoonid.put("clear sky", new Image("file:resources/weather/clearnight.png"));
        ikoonid.put("overcast clouds", new Image("file:resources/weather/cloudynight.png"));
        ikoonid.put("broken clouds", new Image("file:resources/weather/cloudynight.png"));
        ikoonid.put("moderate rain", new Image("file:resources/weather/rainnight.png"));
        return ikoonid;
    }





}
