class itemPerpustakaan {
    String judul ;
    int tahunTerbit ;

    public itemPerpustakaan (String judul, int tahunTerbit){
        this.judul = judul ;
        this.tahunTerbit = tahunTerbit ;
    }

    public void displayInfo(){
        System.out.println("Judul : "+ judul);
        System.out.println("Tahun Terbit : "+tahunTerbit);
    }
}

class buku extends itemPerpustakaan {
    private String pengarang ;
    private int jumlahHalaman ;

    public buku (String judul, int tahunTerbit, String pengarang, int jumlahHalaman){
        super(judul, tahunTerbit);
        this.pengarang = pengarang ;
        this.jumlahHalaman = jumlahHalaman ;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Pengarang : " + pengarang);
        System.out.println("Jumlah Halaman : " + jumlahHalaman);
    }
}

class majalah extends itemPerpustakaan {
    private String edisi ;
    private String bulanTerbit ;

    public majalah (String judul, int tahunTerbit, String edisi, String bulanTerbit){
        super(judul, tahunTerbit);
        this.edisi = edisi ;
        this.bulanTerbit = bulanTerbit ;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Pengarang : " + edisi);
        System.out.println("Jumlah Halaman : " + bulanTerbit);
    }
}

public class utama {
    public static void main(String[] args) {
        buku buku = new buku("Kancil", 2000, "nupi", 35);
        majalah majalah = new majalah("bobo", 2010, "terbatas", "november");

        buku.displayInfo();
        majalah.displayInfo();
    }
}
