abstract class Zakat {
    protected int umur;

    public Zakat(int umur) {
        this.umur = umur;
    }

    public abstract int hitungZakat();
}

class ZakatKambing extends Zakat {
    private int banyak;

    public ZakatKambing(int umur, int banyak) {
        super(umur);
        this.banyak = banyak;
    }

    @Override
    public int hitungZakat() {
        if (umur > 2 && banyak > 100) {
            return banyak / 100;  // kelipatan 100
        }
        return 0;
    }
}

class ZakatSapi extends Zakat {
    private int banyak;

    public ZakatSapi(int umur, int banyak) {
        super(umur);
        this.banyak = banyak;
    }

    @Override
    public int hitungZakat() {
        if (umur > 5 && banyak > 2) {
            return banyak / 2;  // kelipatan 2
        }
        return 0;
    }
}

public class demoZakat {
    public static void main(String[] args) {
        Zakat[] daftarZakat = new Zakat[2];

        daftarZakat[0] = new ZakatKambing(3, 250); // harus zakat 2
        daftarZakat[1] = new ZakatSapi(6, 5);      // harus zakat 2

        for (Zakat z : daftarZakat) {
            System.out.println("Jumlah yang harus dizakatkan: " + z.hitungZakat());
        }
    }
}

