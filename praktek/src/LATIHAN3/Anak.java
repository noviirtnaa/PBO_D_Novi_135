package LATIHAN3;

public class Anak extends Keluarga{
    public Anak (String namaDepan, String namaBelakang){
        super(namaDepan, namaBelakang);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama Depan: " +getNamaDepan());
        System.out.println("Nama Belakang: "+getNamaBelakang());
    }
}
