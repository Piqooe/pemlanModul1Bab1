package tugas_praktikum.uap;

public class Mobil extends Kendaraan {
    private int jumlahKursi;

    public Mobil(String kode, String nama, double harga, int jumlahKursi) {
        super(kode, nama, harga);
        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    @Override
    public void tampilInfo() {
        System.out.printf(java.util.Locale.US, "[MOBIL] Kode: %-5s | Nama: %-15s | Kursi: %d | Tarif: Rp%,.0f/hari | Status: %s\n",
                getKodeKendaraan(), getNamaKendaraan(), jumlahKursi, getHargaSewaPerHari(), isTersedia() ? "Tersedia" : "Disewa");
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double total = super.hitungBiayaDasar(lamaSewa);
        if (jumlahKursi > 5) {
            total += 50000;
        }
        return total;
    }
}
