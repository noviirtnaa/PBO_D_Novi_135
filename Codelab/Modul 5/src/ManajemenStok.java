import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public ManajemenStok() {
    }

    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        daftarBarang.add(new Barang("Pensil", 50));
        daftarBarang.add(new Barang("Buku", 30));
        daftarBarang.add(new Barang("Penghapus", 20));
        daftarBarang.remove(1);
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                switch (pilihan) {
                    case 0:
                        System.out.println(" Terima kasih!");
                        break;
                    case 1:
                        System.out.print("Masukkan nama barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan stok awal: ");

                        try {
                            int stok = scanner.nextInt();
                            daftarBarang.add(new Barang(nama, stok));
                            System.out.println("Barang berhasil ditambahkan.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input stok harus berupa angka!");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println(" Stok barang kosong.");
                            break;
                        }
                        System.out.println("\nDaftar Barang:");
                        for (int i = 0; i < daftarBarang.size(); ++i) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". " + b.getNama() + " - Stok: " + b.getStok());
                        }
                        break;
                    case 3:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("⚠️ Tidak ada barang untuk dikurangi.");
                        } else {
                            System.out.println("\nPilih barang untuk dikurangi stok:");
                            for (int i = 0; i < daftarBarang.size(); ++i) {
                                Barang b = daftarBarang.get(i);
                                System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                            }

                            try {
                                System.out.print("Masukkan nomor indeks barang: ");
                                int indeks = scanner.nextInt();

                                Barang barangDipilih = daftarBarang.get(indeks);
                                System.out.print("Masukkan jumlah yang ingin dikurangi: ");
                                int jumlahKurang = scanner.nextInt();

                                if (jumlahKurang > barangDipilih.getStok()) {
                                    throw new StokTidakCukupException(
                                            " Stok untuk " + barangDipilih.getNama() +
                                                    " hanya tersisa " + barangDipilih.getStok()
                                    );
                                }

                                barangDipilih.setStok(barangDipilih.getStok() - jumlahKurang);
                                System.out.println(" Stok berhasil dikurangi.");
                            } catch (InputMismatchException e) {
                                System.out.println(" Input harus berupa angka!");
                                scanner.nextLine();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println(" Indeks tidak valid!");
                            } catch (StokTidakCukupException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    default:
                        System.out.println(" Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
