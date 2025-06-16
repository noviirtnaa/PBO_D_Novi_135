package LATIHAN2;

public class Perusahaan extends Institusi{
    public Perusahaan (String nama, String nomer){
        super (nama, nomer);
    }

    public void displayInfo(String alamat) {
        System.out.println("Nama perusahaan : " + getNama());
        System.out.println("Nomer perusahaan : " + getNomer());
        System.out.println("Alamat perusahaan : " + alamat);
    }

    // Method overloading 2: menerima 2 parameter tambahan
    public void displayInfo(String alamat, int jumlahKaryawan) {
        System.out.println("Nama perusahaan : " + getNama());
        System.out.println("Nomer perusahaan : " + getNomer());
        System.out.println("Alamat perusahaan : " + alamat);
        System.out.println("Jumlah karyawan : " + jumlahKaryawan);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama perusahaan : " +getNama());
        System.out.println("Nomer perusahaan : " +getNomer());
    }
}
