package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {

    public String username;
    public String password;
    private Scanner input = new Scanner(System.in);

    public Admin(String username, String password) {
        super(username, password);
        this.username = username;
        this.password = password;
    }

    @Override
    public void manageItems() {
        while (true) {
            System.out.println("=======================================");
            System.out.println("============ KELOLA BARANG ============");
            System.out.println("=======================================");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            int pilih;
            try {
                pilih = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilih) {
                case 0 -> {
                    return; // keluar dari loop
                }
                case 1 -> tampilkanSemuaLaporan();
                case 2 -> tandaiBarangClaimed();
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tampilkanSemuaLaporan() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
        } else {
            int idx = 1;
            for (Item item : LoginSystem.reportedItems) {
                System.out.printf("%d. %s | %s | %s | Status: %s%n",
                        idx++, item.getItemName(), item.getDescription(), item.getLocation(), item.getStatus());
            }
        }
    }

    private void tandaiBarangClaimed() {
        boolean ada = false;
        System.out.println("Daftar barang dengan status 'Reported':");
        int i = 1;
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                System.out.printf("%d. %s | %s | %s%n", i, item.getItemName(), item.getDescription(), item.getLocation());
                ada = true;
            }
            i++;
        }

        if (!ada) {
            System.out.println("Tidak ada barang dengan status 'Reported'.");
            return;
        }

        System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");
        try {
            int index = Integer.parseInt(input.nextLine());
            if (index < 1 || index > LoginSystem.reportedItems.size()) {
                System.out.println("Indeks tidak valid!");
                return;
            }

            Item item = LoginSystem.reportedItems.get(index - 1);
            if ("Reported".equalsIgnoreCase(item.getStatus())) {
                item.setStatus("Claimed");
                System.out.println("Barang berhasil ditandai sebagai 'Claimed'.");
            } else {
                System.out.println("Barang sudah berstatus 'Claimed'.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
        }
    }

    @Override
    public void manageUsers() {
        while (true) {
            System.out.println("=======================================");
            System.out.println("=========== KELOLA MAHASISWA ==========");
            System.out.println("=======================================");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih: ");

            int pilih;
            try {
                pilih = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilih) {
                case 0 -> {
                    return;
                }
                case 1 -> tambahMahasiswa();
                case 2 -> hapusMahasiswa();
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tambahMahasiswa() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = input.nextLine();

        LoginSystem.userList.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void hapusMahasiswa() {
        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
        String nimHapus = input.nextLine();

        boolean found = false;
        for (int i = 0; i < LoginSystem.userList.size(); i++) {
            User u = LoginSystem.userList.get(i);
            if (u instanceof Mahasiswa m && m.getNim().equals(nimHapus)) {
                LoginSystem.userList.remove(i);
                System.out.println("Mahasiswa berhasil dihapus.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println("========================");
            System.out.println("========= MENU =========");
            System.out.println("========================");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih: ");

            int pilih;
            try {
                pilih = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilih) {
                case 1 -> manageItems();
                case 2 -> manageUsers();
                case 0 -> {
                    System.out.println("Logout berhasil.");
                    LoginSystem.startCLI();
                    return;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    @Override
    public void login() {
    }
}
