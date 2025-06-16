package LATIHAN2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Perusahaan perusahaan = new Perusahaan("Jaya Baru", "2");
        Pemerintah pemerintah = new Pemerintah("Novi", "123");

        ArrayList<Institusi> institusis = new ArrayList<>();

        try {

            System.out.println("Pilihan login:");
            System.out.println("1. Perusahaan");
            System.out.println("2. Pemerintah");
            System.out.println("3. Logout");
            System.out.println("Pilihan Login: ");

            Scanner scanner = new Scanner(System.in);

            int Pilihan = scanner.nextInt();
            scanner.nextLine();

            if (Pilihan == 1) {
                perusahaan.displayInfo();
            } else if (Pilihan == 2) {
                pemerintah.displayInfo();
            } else if (Pilihan == 3) {
                System.out.println("Anda telah logout");
            } else {
                System.out.println("Pilihan anda tidak valid");
            }

        } catch (InputMismatchException e){
            System.out.println("Harus berupa angka!");
        }

    }
}
