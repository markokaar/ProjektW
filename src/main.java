

public class Main {
    public static void main(String[] args){
        Jsonweb test1 = new Jsonweb("Tartu");
        Jsonweb test2 = new Jsonweb("Jõgeva");

        System.out.println(test1.getCity());
        System.out.println(test1.getData());
        System.out.println(test2.getData());
        System.out.println(Jsonparse("Tartu"));
    }
}
