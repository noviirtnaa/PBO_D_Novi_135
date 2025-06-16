

import java.util.ArrayList;
import java.util.Scanner;


// ======================= CLASS LAIN =======================

abstract class Keluargaa {
    public String namaDepan;
    public String namaBelakang;

    public Keluargaa(String namaDepan, String namaBelakang) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public abstract void displayInfo();
}

class Anakk extends Keluargaa {
    private double[] beratBadan = new double[7]; // index 1–6

    public Anakk(String namaDepan, String namaBelakang) {
        super(namaDepan, namaBelakang);
    }

    public void setBeratBadan(int bulan, double berat) {
        if (bulan >= 1 && bulan <= 6) {
            beratBadan[bulan] = berat;
        }
    }

    public double getBeratBadan(int bulan) {
        if (bulan >= 1 && bulan <= 6) {
            return beratBadan[bulan];
        }
        return 0;
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama depan: " + getNamaDepan());
        System.out.println("Nama belakang: " + getNamaBelakang());
        System.out.println("Berat badan per bulan:");
        for (int i = 1; i <= 6; i++) {
            System.out.println("Bulan " + i + ": " + getBeratBadan(i) + " kg");
        }
    }
}

class orangTua extends Keluargaa {
    private ArrayList<Anakk> anakList = new ArrayList<>();

    public orangTua(String namaDepan, String namaBelakang) {
        super(namaDepan, namaBelakang);
    }

    public void tambahAnak(Anakk anak) {
        anakList.add(anak);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama depan orang tua: " + getNamaDepan());
        System.out.println("Nama belakang orang tua: " + getNamaBelakang());
        System.out.println("Daftar Anak:");
        for (Anakk anak : anakList) {
            anak.displayInfo();
            System.out.println("---");
        }
    }
}


public class coba2 {
    public static void main(String[] args) {
        ArrayList<Keluargaa> keluargaas = new ArrayList<>();

        // Membuat data contoh
        orangTua ayah = new orangTua("Budi", "Santoso");

        Anakk anak1 = new Anakk("Andi", "Santoso");
        anak1.setBeratBadan(1, 3.5);
        anak1.setBeratBadan(2, 4.2);
        anak1.setBeratBadan(3, 4.8);
        anak1.setBeratBadan(4, 5.3);
        anak1.setBeratBadan(5, 5.7);
        anak1.setBeratBadan(6, 6.1);

        Anakk anak2 = new Anakk("Siti", "Santoso");
        anak2.setBeratBadan(1, 3.2);
        anak2.setBeratBadan(2, 3.9);
        anak2.setBeratBadan(3, 4.5);
        anak2.setBeratBadan(4, 5.0);
        anak2.setBeratBadan(5, 5.4);
        anak2.setBeratBadan(6, 5.8);

        ayah.tambahAnak(anak1);
        ayah.tambahAnak(anak2);

        keluargaas.add(ayah);
        keluargaas.add(anak1);
        keluargaas.add(anak2);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tampilkan Data Semua Anak");
            System.out.println("2. Tampilkan Data Orang Tua dan Anak-anaknya");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    anak1.displayInfo();
                    System.out.println();
                    anak2.displayInfo();
                    break;
                case 2:
                    ayah.displayInfo();
                    break;
                case 3:
                    System.out.println("Anda telah keluar.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (pilihan != 3);
    }
}


