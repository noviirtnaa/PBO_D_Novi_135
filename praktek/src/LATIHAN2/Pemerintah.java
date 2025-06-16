package LATIHAN2;

public class Pemerintah extends Institusi{
    public Pemerintah (String nama, String nomer){
        super(nama, nomer);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama Pemerintah : "+getNama());
        System.out.println("Nomer Pemerintah: "+getNomer());
    }
}
