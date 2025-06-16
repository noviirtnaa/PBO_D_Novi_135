package LATIHAN;

    public class Camat extends Wilayah{
        public Camat(String namaWilayah, String namaKepalaDesa) {
            super(namaWilayah, namaKepalaDesa);
        }

        @Override
        public void tampilkanInfo() {
            System.out.println("nama wilayah:" + getNamaWilayah());
            System.out.println("nama kepala desa:" + getNamaKepalaDesa());
        }

        public void camat1(){
            System.out.println("HALOOOOO");
        }
    }
