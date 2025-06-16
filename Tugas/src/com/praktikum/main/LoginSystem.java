package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ObservableList<Item> reportedItems = FXCollections.observableArrayList();

    public static void main(String[] args) {
        startCLI();
    }

    public static void startCLI() {
        Scanner input = new Scanner(System.in);

        if (userList.isEmpty()) {
            userList.add(new Admin("novi", "135"));
            userList.add(new Mahasiswa("novi", "135"));
        }

        System.out.println("=======================================");
        System.out.println("============== PILIH LOGIN ============");
        System.out.println("=======================================");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih: ");

        int pilihan = 0;
        try {
            pilihan = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
            startCLI();
            return;
        }

        switch (pilihan) {
            case 1 -> loginAdmin(input);
            case 2 -> loginMahasiswa(input);
            default -> {
                System.out.println("Pilihan tidak valid!");
                startCLI();
            }
        }
    }

    private static void loginAdmin(Scanner input) {
        System.out.println("\n[Login Admin]");
        System.out.print("Username : ");
        String user = input.nextLine();
        System.out.print("Password : ");
        String pass = input.nextLine();

        for (User u : userList) {
            if (u instanceof Admin a && a.username.equals(user) && a.password.equals(pass)) {
                System.out.println("Login Admin Berhasil!\n");
                u.displayInfo();
                u.displayAppMenu();
                return;
            }
        }

        System.out.println("Login gagal!");
        startCLI();
    }

    private static void loginMahasiswa(Scanner input) {
        System.out.println("\n[Login Mahasiswa]");
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("NIM  : ");
        String nim = input.nextLine();

        for (User u : userList) {
            if (u instanceof Mahasiswa m && m.getNama().equals(nama) && m.getNim().equals(nim)) {
                System.out.println("Login Mahasiswa Berhasil!\n");
                u.displayInfo();
                u.displayAppMenu();
                return;
            }
        }

        System.out.println("Login gagal!");
        startCLI();
    }
}
