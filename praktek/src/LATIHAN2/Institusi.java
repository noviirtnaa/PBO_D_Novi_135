package LATIHAN2;

public abstract class Institusi {
    public String nama;
    public String nomer;

    public Institusi (String nama, String nomer){
        this.nama =nama;
        this.nomer=nomer;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public abstract void displayInfo();
}
