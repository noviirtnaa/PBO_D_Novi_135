import java.util.Scanner;

abstract class Shape {
    public abstract double luas();
}

class SegiEmpat extends Shape {
    private double panjang;
    private double lebar;

    public SegiEmpat(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double luas() {
        return panjang * lebar;
    }
}

class Segitiga extends Shape {
    private double alas;
    private double tinggi;

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double luas() {
        return 0.5 * alas * tinggi;
    }
}

class Lingkaran extends Shape {
    private double jari;

    public Lingkaran(double jari) {
        this.jari = jari;
    }

    @Override
    public double luas() {
        return 3.14 * jari * jari;
    }
}

public class demoShape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape[] shapes = new Shape[3];

        System.out.print("Masukkan panjang segi empat: ");
        double panjang = scanner.nextDouble();
        System.out.print("Masukkan lebar segi empat: ");
        double lebar = scanner.nextDouble();
        shapes[0] = new SegiEmpat(panjang, lebar);

        System.out.print("Masukkan alas segitiga: ");
        double alas = scanner.nextDouble();
        System.out.print("Masukkan tinggi segitiga: ");
        double tinggi = scanner.nextDouble();
        shapes[1] = new Segitiga(alas, tinggi);

        System.out.print("Masukkan jari-jari lingkaran: ");
        double jari = scanner.nextDouble();
        shapes[2] = new Lingkaran(jari);

        System.out.println("\nHasil Perhitungan Luas:");
        for (Shape s : shapes) {
            System.out.println("Luas: " + s.luas());
        }

        scanner.close();
    }
}
