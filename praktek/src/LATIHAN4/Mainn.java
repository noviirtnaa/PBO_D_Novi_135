package LATIHAN4;

import LATIHAN3.Anak;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        ArrayList<Keluargaa>keluargaas = new ArrayList<>();

        Anakk anak = new Anakk("Novii", "Ratna");


        orangTua orangTua = new orangTua("Beti", "Dwi Aristiani");



        System.out.println("Pilihan:");
        System.out.println("1. Anak");
        System.out.println("2. Orang Tua");
        System.out.println("3. Keluar");
        System.out.println("Masukkan Pilihan: ");

        Scanner scanner = new Scanner(System.in);
        int Pilihan ;
        Pilihan = scanner.nextInt();
        scanner.nextLine();

        if (Pilihan == 1){
            anak.displayInfo();
        } else if (Pilihan == 2) {
            orangTua.displayInfo();
        } else if (Pilihan == 3) {
            System.out.println("Anda telah keluar");
        } else {
            System.out.println("Pilihan tidak valid");
        }

    }
}
