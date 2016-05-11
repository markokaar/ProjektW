import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Linnad {
    public List<String> linnadelist = new ArrayList<String>();

    List<String> loeAndmed(){
        try {
            java.io.File fail = new java.io.File("linnad.txt");
            java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8");

        while (sc.hasNextLine()) {
            String rida = sc.nextLine();
            linnadelist.add(rida);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return linnadelist;

        }

    void lisaLinn(String linnanimi){
        try {
            linnadelist = loeAndmed();

            PrintWriter writer = new PrintWriter("linnad.txt", "UTF-8");

            for(String linn : linnadelist){
                writer.println(linn);
            }
            writer.println(linnanimi.substring(0, 1).toUpperCase() + linnanimi.substring(1));

            writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    void eemaldaLinn(String linnanimi){
        try{
        linnadelist = loeAndmed();
        linnadelist.remove(linnanimi);

        PrintWriter writer = new PrintWriter("linnad.txt", "UTF-8");

        for(String linn : linnadelist){
            writer.println(linn);
        }

        writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
