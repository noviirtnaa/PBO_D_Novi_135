abstract class Staff {
    public int masaKerja;

    public Staff(int masaKerja) {
        this.masaKerja = masaKerja;
    }

    public abstract void bayarGaji();
}

class Programmer extends Staff {
    public Programmer(int masaKerja) {
        super(masaKerja);
    }

    public void bayarGaji() {
        if (masaKerja < 2) {
            System.out.println("Gaji Programmer: 2 juta");
        } else {
            System.out.println("Gaji Programmer: 4 juta");
        }
    }
}

class SistemAnalis extends Staff {
    public SistemAnalis(int masa_kerja) {
        super(masa_kerja);
    }

    public void bayarGaji() {
        if (masaKerja < 2) {
            System.out.println("Gaji Sistem Analis: 4 juta");
        } else {
            System.out.println("Gaji Sistem Analis: 6 juta");
        }
    }
}

public class demoStaf {
    public static void main(String[] args) {
        Staff s1 = new Programmer(1);
        Staff s2 = new Programmer(3);
        Staff s3 = new SistemAnalis(1);
        Staff s4 = new SistemAnalis(3);

        s1.bayarGaji();
        s2.bayarGaji();
        s3.bayarGaji();
        s4.bayarGaji();
    }
}
