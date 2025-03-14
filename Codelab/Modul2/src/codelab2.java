// Kelas RekeningBank
class RekeningBank {
    // Atribut
    String nomorRekening;
    String namaPemilik;
    double saldo;

    // Method untuk menampilkan informasi rekening
    public void informasi() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println(); // Spasi tambahan
    }

    // Method untuk menyetor uang
    public void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    // Method untuk menarik uang
    public void tarikUang(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        }
    }
}


// Kelas Codelab_2
public class codelab2 {
    public static void main(String[] args) {
        // Membuat objek rekening1
        RekeningBank rekening1 = new RekeningBank();
        rekening1.nomorRekening = "2024135";
        rekening1.namaPemilik = "Novi";
        rekening1.saldo = 100000;

        // Membuat objek rekening2
        RekeningBank rekening2 = new RekeningBank();
        rekening2.nomorRekening = "2024135";
        rekening2.namaPemilik = "Keysa";
        rekening2.saldo = 50000;

        // Menampilkan informasi rekening1 dan rekening2
        rekening1.informasi();
        rekening2.informasi();

        // Melakukan transaksi setor uang
        rekening1.setorUang(50000);
        rekening2.setorUang(50000);
        System.out.println(); // Spasi tambahan

        // Melakukan transaksi tarik uang
        rekening1.tarikUang(20000);
        rekening2.tarikUang(30000);
        System.out.println(); // Spasi tambahan

        // Menampilkan informasi rekening1 dan rekening2 setelah transaksi
        rekening1.informasi();
        rekening2.informasi();
    }
}