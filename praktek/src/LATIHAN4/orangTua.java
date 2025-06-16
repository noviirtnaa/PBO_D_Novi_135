package LATIHAN4;

public class orangTua extends Keluargaa{
    public orangTua (String namaDepan, String namaBelakang){
        super(namaDepan, namaBelakang);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama depan orang tua: " +getNamaDepan());
        System.out.println("Nama belakang orang tua: "+getNamaBelakang());
    }
}
