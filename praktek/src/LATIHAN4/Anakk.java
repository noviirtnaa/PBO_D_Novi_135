package LATIHAN4;

public class Anakk extends Keluargaa{
    public Anakk (String namaDepan, String namaBelakang){
        super(namaDepan, namaBelakang);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama depan: " + getNamaDepan());
        System.out.println("Nama belakang: +" +getNamaBelakang());
    }
}
