package LATIHAN5;

public class Pengajar extends PesertaKursus implements peserta{
    public Pengajar (String nama, String nim){
        super(nama, nim);
    }

    public void displayInfo(String nama, String nim, String alamat){
        System.out.println("Nama : " +getNama());
        System.out.println("NIM: " +getNim());
        System.out.println("Alamat: "+alamat);
    }

    public void displayInfo (String nama, String nim, String alamat, String no){
        System.out.println("Nama : " +getNama());
        System.out.println("NIM: " +getNim());
        System.out.println("Alamat: "+alamat);
        System.out.println("No: " +no);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama pengajar: " +getNama());
        System.out.println("NIM: " +getNim());
    }
}
