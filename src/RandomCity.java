import java.util.concurrent.ThreadLocalRandom;

public class RandomCity {

    String find() {
        try {
            java.io.File fail = new java.io.File("C:/Users/Marko/Downloads");
            java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8");
            int arv = ThreadLocalRandom.current().nextInt(0, 20000 + 1);

            if (!fail.exists())
                System.out.println("Faili ei leidnud!");



            // copytud praxi näitest
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                System.out.print(tükid[tükid.length-2]+" "+tükid[tükid.length-1]);
                System.out.println();
            }


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "tartuasd";
    }
}
