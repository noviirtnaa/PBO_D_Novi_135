package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    private Scanner input = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login() {
        System.out.println("Yang penting di override");
    }

    public void reportItem() {
        System.out.println("=======================================");
        System.out.println("============ LAPORAN BARANG ============");
        System.out.println("=======================================");
        System.out.print("Nama Barang         : ");
        String namaBarang = input.nextLine();

        System.out.print("Deskripsi Barang    : ");
        String deskripsiBarang = input.nextLine();

        System.out.print("Lokasi Terakhir     : ");
        String lokasiTerakhir = input.nextLine();

        Item item = new Item(namaBarang, deskripsiBarang, lokasiTerakhir, "Reported");
        LoginSystem.reportedItems.add(item);

        System.out.println("\nLaporan berhasil dikirim!");
        System.out.println("Nama Barang     : " + namaBarang);
        System.out.println("Deskripsi       : " + deskripsiBarang);
        System.out.println("Lokasi Terakhir : " + lokasiTerakhir);

        System.out.println("\nTekan Enter untuk kembali...");
        input.nextLine();
        displayAppMenu();
    }

    public void viewReportedItems() {
        System.out.println("=======================================");
        System.out.println("======= DAFTAR BARANG DILAPORKAN =======");
        System.out.println("=======================================");

        boolean adaLaporan = false;
        int idx = 1;
        for (Item item : LoginSystem.reportedItems) {
            if ("Reported".equals(item.getStatus())) {
                System.out.println(idx + ". " + item.getItemName() + " | " + item.getDescription() + " | " + item.getLocation());
                adaLaporan = true;
            }
            idx++;
        }

        if (!adaLaporan) {
            System.out.println("Belum ada laporan barang.");
        }

        System.out.println("\nTekan Enter untuk kembali...");
        input.nextLine();
        displayAppMenu();
    }

    public void displayAppMenu() {
        System.out.println("=======================================");
        System.out.println("============ MENU MAHASISWA ============");
        System.out.println("=======================================");
        System.out.println("1. Laporkan Barang Temuan/Hilang");
        System.out.println("2. Lihat Daftar Laporan");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        int pilih = -1;
        try {
            pilih = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
            input.nextLine();
            displayAppMenu();
            return;
        }

        switch (pilih) {
            case 1:
                reportItem();
                break;
            case 2:
                viewReportedItems();
                break;
            case 0:
                System.out.println("\nLogout berhasil\n");
                LoginSystem.startCLI();
                break;
            default:
                System.out.println("Pilihan tidak valid! Tekan Enter untuk kembali...");
                input.nextLine();
                displayAppMenu();
        }
    }
}
