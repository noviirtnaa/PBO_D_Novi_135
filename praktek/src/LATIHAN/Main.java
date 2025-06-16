package LATIHAN;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Wilayah> wilayahs = new ArrayList<>();

        Camat objek = new Camat("Malang", "nupi");
        Desa objek1 = new Desa("Bjn", "NP");

        System.out.println("1. Camat");
        System.out.println("2. login sebagai Desa");
        System.out.println("3. Keluar");
        System.out.println("Masukkan pilihan : ");


        Scanner input = new Scanner(System.in);
        int pilih;
        pilih = input.nextInt();
        input.nextLine();

        if (pilih == 1){
            objek.camat1();

        } else if (pilih == 2) {
            objek1.desa1();
        } else if (pilih == 3) {
            System.out.println("Anda telah logout");
        } else{
            System.out.println("Pilihan tidak valid");
        }
    }
}


