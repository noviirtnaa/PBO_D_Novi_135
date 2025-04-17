import java.util.Scanner;

// Kelas Admin
class Admin {
    private String username;
    private String password;

    // Konstruktor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}

// Kelas Mahasiswa
class Mahasiswa {
    private String nama;
    private String nim;

    // Konstruktor
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public void login(String nama, String nim) {
        if (this.nama.equals(nama) && this.nim.equals(nim)) {
            displayInfo();
        } else {
            System.out.println("Login gagall! Nama atau NIM salah.");
        }
    }

    public void displayInfo() {
        System.out.println("Login berhasil!");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}

// Kelas tugas2 (kelas utama)
public class tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek Admin dengan username dan password
        Admin admin = new Admin("admin", "135");

        // Membuat objek Mahasiswa dengan nama dan NIM
        Mahasiswa mahasiswa = new Mahasiswa("nupi", "135");

        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                admin.login(username, password); // Memanggil metode login
                break;

            case 2:
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                mahasiswa.login(nama, nim); // Memanggil metode login
                break;

            default:
                System.out.println("Pilihan tidak valid! Silakan pilih 1 atau 2.");
                break;
        }

        scanner.close();
    }
}