// Kelas Hewan
class namaHewan {
    // Atribut
    String nama;
    String jenis;
    String suara;

    // Metode untuk menampilkan informasi hewan
    void informasi() {
        System.out.println("Nama: " + nama);
        System.out.println("Jenis: " + jenis);
        System.out.println("Suara: " + suara);
    }
}

// Kelas Main
public class codelab1 {
    public static void main(String[] args) {
        // Membuat objek hewan1
        namaHewan hewan1 = new namaHewan();
        hewan1.nama = "Sapi";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Mooooo---\n";

        // Membuat objek hewan2
        namaHewan hewan2 = new namaHewan();
        hewan2.nama = "Kucing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Miauuww";

        // Menampilkan informasi hewan1 dan hewan2
        hewan1.informasi();
        hewan2.informasi();
    }
}