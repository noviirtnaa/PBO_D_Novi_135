package LATIHAN4;

public abstract class Keluargaa {
    public String namaDepan ;
    public String namaBelakang ;

    public Keluargaa (String namaDepan, String namaBelakang){
        this.namaDepan = namaDepan ;
        this.namaBelakang = namaBelakang ;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public abstract void displayInfo();
}
