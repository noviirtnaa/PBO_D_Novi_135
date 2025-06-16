package LATIHAN3;

public class Ortu extends Keluarga {
    public Ortu (String namaDepan, String namaBelakang){
        super(namaDepan, namaBelakang);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama depan :"+ getNamaDepan());
        System.out.println("Nama belakang: " + getNamaBelakang());
    }
}
