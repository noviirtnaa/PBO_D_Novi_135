import java.util.Arrays;
import java.util.Scanner;

public class coba {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta jumlah item
        System.out.print("Masukkan jumlah item: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline

        String[] items = new String[n];

        // Memasukkan item ke array
        for(int i = 0; i < n; i++) {
            System.out.print("Masukkan item ke-" + (i+1) + ": ");
            items[i] = scanner.nextLine();
        }

        // Mengurutkan array items secara alfabetis
        Arrays.sort(items);

        // Menampilkan hasil pengurutan
        System.out.println("\nItem yang sudah diurutkan:");
        for(String item : items) {
            System.out.println(item);
        }

        scanner.close();
    }
}
