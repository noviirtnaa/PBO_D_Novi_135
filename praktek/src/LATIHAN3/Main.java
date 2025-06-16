package LATIHAN3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Keluarga> keluargas = new ArrayList<>();

        Anak anak = new Anak("Nupi", "Ratna");
        Anak anak2 = new Anak("Nupi", "Ratna");
        Ortu ortu = new Ortu("nupi", "ratna");

        System.out.println("Pilihan login:");
        System.out.println("1. Anak");
        System.out.println("2. Ortu");
        System.out.println("3. Logout");
        System.out.println("Pilihlah : ");

        Scanner scanner = new Scanner(System.in);
        int input ;

        input = scanner.nextInt();
        scanner.nextLine();

        if (input == 1){
            anak.displayInfo();
            anak2.displayInfo();
        } else if (input == 2) {
            ortu.displayInfo();
        } else if (input == 3) {
            System.out.println("Anda telah logout");
        } else {
            System.out.println("Input tidak valid");
        }
    }
}


