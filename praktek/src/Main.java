import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Farmer farmer1 = new Farmer();
        Farmer farmer2 = new Farmer();
        Plants plants1 = new Plants();
        Plants plants2 = new Plants();

        farmer1.nama = "Nupi";
        farmer2.nama = "Key";

        plants1.nama = "Mawar" ;
        plants2.nama = "Melati" ;

        farmer1.favorit = plants1.nama;
        farmer2.favorit = plants2.nama;

        System.out.println("Hallo");
        System.out.println("Data dan waktu: " + new Date());

        farmer1.talk();
        farmer2.talk();
    }
}
