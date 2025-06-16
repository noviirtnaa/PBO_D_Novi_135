import java.util.Scanner;

public class tugas1 {
    private static final Scanner tugas1 = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Pilih Login:\n1. Admin\n2. Mahasiswa\nMasukkan Pilihan:");
            int pilihan = tugas1.nextInt();
            tugas1.nextLine();
            switch (pilihan) {
                case 1:
                    admin();
                    break;
                case 2:
                    mahasiswa();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    public static void admin() {
        System.out.println("Masukkan username: ");
        String usernameAdmin = tugas1.nextLine();
        System.out.println("Masukkan Password: ");
        String passwordAdmin = tugas1.nextLine();

        if (usernameAdmin.equals("novi") && passwordAdmin.equals("123")) {
            System.out.println("Login Admin Berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    public static void mahasiswa() {
        System.out.println("Masukkan username: ");
        String usernamemahasiswa = tugas1.nextLine();
        System.out.println("Masukkan NIM: ");
        String passwordmahasiswa = tugas1.nextLine();

        if (usernamemahasiswa.equals("novi" ) && passwordmahasiswa.equals("202410370110135")) {
            System.out.println("Login Mahasiswa Berhasil!");
            System.out.println("Nama : "+usernamemahasiswa);
            System.out.println("NIM : "+passwordmahasiswa);
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }
}
