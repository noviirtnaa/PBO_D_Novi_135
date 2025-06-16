package LATIHAN5;

public abstract class PesertaKursus {
    public String nama;
    public String nim;

    public PesertaKursus(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public abstract void displayInfo();
}

