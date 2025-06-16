package LATIHAN5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Siswa siswa = new Siswa("Novi", "135");
        Pengajar pengajar = new Pengajar("key", "140");

        ArrayList<PesertaKursus> pesertaKursuses = new ArrayList<>();

        System.out.println("Pilihan: ");
        System.out.println("1. Siswa");
        System.out.println("2. Pengajar");
        System.out.println("3. Keluar");
        System.out.println("Pilihlah: ");

        try {

            Scanner scanner = new Scanner(System.in);
            int Pilihan = scanner.nextInt();
            scanner.nextLine();

            if (Pilihan == 1) {
                siswa.displayInfo();
            } else if (Pilihan == 2) {
                pengajar.displayInfo();
            } else if (Pilihan == 3) {
                System.out.println("Anda telah logout!");
            } else {
                throw new CustomInputMismatchException("Pilihan tidak tersedia");
            }

        }catch (InputMismatchException e){
            System.out.println("Masukkan angka");
        }catch (CustomInputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}
