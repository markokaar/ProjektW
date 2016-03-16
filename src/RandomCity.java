import java.util.concurrent.ThreadLocalRandom;
import java.net.*;
import java.io.*;

public class RandomCity {
    String suvalinn;
    String find() {
        try {
            //java.io.File fail = new java.io.File("C:/Users/Marko/Downloads");
            //java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8");
            int arv = ThreadLocalRandom.current().nextInt(0, 74000 + 1);

            URL linnad = new URL("http://openweathermap.org/help/city_list.txt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(linnad.openStream()));

            String inputLine;
            String e;
            int a = 0;
            while ((inputLine = in.readLine()) != null && a != arv) {
                a++;
                //System.out.println(a);
                if (a == arv) {
                    suvalinn = inputLine.split("\t")[1];
                    //System.out.println(suvalinn);
                    break;
                }

                //System.out.println((inputLine.split("\t")[1]));
                //System.out.println(suvalinn);

            }
            in.close();
            //if (!fail.exists())
            //    System.out.println("Faili ei leidnud!");



            // copytud praxi näitest
            //while (sc.hasNextLine()) {
            //    String rida = sc.nextLine();
            //    String[] tükid = rida.split(" ");
            //    System.out.print(tükid[tükid.length-2]+" "+tükid[tükid.length-1]);
            //    System.out.println();
            //}


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            suvalinn = "error";
        }

        return suvalinn;
    }
}
