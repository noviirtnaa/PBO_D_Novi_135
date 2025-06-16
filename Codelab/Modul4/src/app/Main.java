package app;
import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        Buku revolusi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku lautBercerita = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        Anggota Novi = new Anggota("Novi Ratna", "D135");
        Anggota Keysa = new Anggota("Keysa", "D140");

        System.out.println("=== INFORMASI BUKU ===");
        revolusi.displayInfo();
        System.out.println();
        lautBercerita.displayInfo();
        System.out.println("\n=== DATA ANGGOTA ===");

        System.out.print("• ");
        Novi.displayInfo();
        System.out.print("• ");
        Keysa.displayInfo();

        System.out.println("\n=== PROSES PEMINJAMAN ===");
        System.out.println("[Novi Ratna] ");
        System.out.print("  - ");
        Novi.pinjamBuku("Madilog");

        System.out.println("\n[Keysa] ");
        System.out.print("  - ");
        Keysa.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println("\n=== PROSES PENGEMBALIAN ===");
        System.out.println("[Novi Ratna] ");
        System.out.print("  - ");
        Novi.kembalikanBuku("Madilog");

        System.out.println("\n[Keysa] ");
        System.out.print("  - ");
        Keysa.kembalikanBuku("Hainuwele: Sang Putri Kelapa");

        System.out.println("\n=== PROGRAM SELESAI ===");
    }
}
