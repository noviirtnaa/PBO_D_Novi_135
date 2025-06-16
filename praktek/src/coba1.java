import java.util.ArrayList;
import java.util.Scanner;

class Keluarga {
    protected String namaDepan;
    protected String namaBelakang;

    public Keluarga(String namaDepan, String namaBelakang) {
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    public void tampilkanIdentitas() {
        System.out.println("Nama: " + namaDepan + " " + namaBelakang);
    }
}

class OrangTua extends Keluarga {
    private ArrayList<Anak> daftarAnak;

    public OrangTua(String namaDepan, String namaBelakang) {
        super(namaDepan, namaBelakang);
        this.daftarAnak = new ArrayList<>();
    }

    public void tambahAnak(Anak anak) {
        daftarAnak.add(anak);
    }

    public int jumlahAnak() {
        return daftarAnak.size();
    }

    public ArrayList<Anak> getDaftarAnak() {
        return daftarAnak;
    }
}

class Anak extends Keluarga {
    private double[] beratBadan;

    public Anak(String namaDepan, String namaBelakang) {
        super(namaDepan, namaBelakang);
        this.beratBadan = new double[6]; // Untuk bulan 1-6
    }

    public void setBeratBadan(int bulan, double berat) {
        if (bulan >= 1 && bulan <= 6) {
            beratBadan[bulan - 1] = berat;
        } else {
            System.out.println("Bulan harus antara 1-6");
        }
    }

    public void tampilkanBeratBadan() {
        System.out.println("Berat Badan " + namaDepan + " " + namaBelakang + ":");
        for (int i = 0; i < beratBadan.length; i++) {
            System.out.println("Bulan " + (i + 1) + ": " + beratBadan[i] + " kg");
        }
    }

    public double[] getBeratBadan() {
        return beratBadan;
    }
}

public class coba1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat data contoh
        OrangTua ayah = new OrangTua("Budi", "Santoso");

        Anak anak1 = new Anak("Andi", "Santoso");
        anak1.setBeratBadan(1, 3.5);
        anak1.setBeratBadan(2, 4.2);
        anak1.setBeratBadan(3, 4.8);
        anak1.setBeratBadan(4, 5.3);
        anak1.setBeratBadan(5, 5.7);
        anak1.setBeratBadan(6, 6.1);

        Anak anak2 = new Anak("Siti", "Santoso");
        anak2.setBeratBadan(1, 3.2);
        anak2.setBeratBadan(2, 3.9);
        anak2.setBeratBadan(3, 4.5);
        anak2.setBeratBadan(4, 5.0);
        anak2.setBeratBadan(5, 5.4);
        anak2.setBeratBadan(6, 5.8);

        ayah.tambahAnak(anak1);
        ayah.tambahAnak(anak2);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan berat badan anak");
            System.out.println("2. Tampilkan jumlah anak");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    if (ayah.jumlahAnak() == 0) {
                        System.out.println("Tidak ada anak terdaftar.");
                        break;
                    }

                    System.out.println("\nDaftar Anak:");
                    for (int i = 0; i < ayah.jumlahAnak(); i++) {
                        System.out.println((i + 1) + ". " +
                                ayah.getDaftarAnak().get(i).namaDepan + " " +
                                ayah.getDaftarAnak().get(i).namaBelakang);
                    }

                    System.out.print("Pilih anak (1-" + ayah.jumlahAnak() + "): ");
                    int pilihAnak = scanner.nextInt() - 1;

                    if (pilihAnak >= 0 && pilihAnak < ayah.jumlahAnak()) {
                        ayah.getDaftarAnak().get(pilihAnak).tampilkanBeratBadan();
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 2:
                    System.out.println("Jumlah anak: " + ayah.jumlahAnak());
                    break;

                case 3:
                    running = false;
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}