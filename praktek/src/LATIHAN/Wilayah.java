package LATIHAN;

abstract public class Wilayah {
    private String namaWilayah;
    private String namaKepalaDesa ;

    public Wilayah (String namaWilayah, String namaKepalaDesa){
        this.namaWilayah = namaWilayah ;
        this.namaKepalaDesa = namaKepalaDesa ;
    }

    public String getNamaWilayah() {
        return namaWilayah;
    }

    public void setNamaWilayah(String namaWilayah) {
        this.namaWilayah = namaWilayah;
    }

    public String getNamaKepalaDesa() {
        return namaKepalaDesa;
    }

    public void setNamaKepalaDesa(String namaKepalaDesa) {
        this.namaKepalaDesa = namaKepalaDesa;
    }

    public abstract void tampilkanInfo();

}

