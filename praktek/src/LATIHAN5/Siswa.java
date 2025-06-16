package LATIHAN5;

public class Siswa extends PesertaKursus implements peserta{
    public Siswa (String nama, String nim){
        super(nama, nim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama siswa :" + getNama());
        System.out.println("NIM siswa: " +getNim());
    }
}
