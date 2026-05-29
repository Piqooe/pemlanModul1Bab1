package tugas_praktikum.uap;

public class Motor extends Kendaraan {
    private String jenisTransmisi;

    public Motor(String kode, String nama, double harga, String jenisTransmisi) {
        super(kode, nama, harga);
        this.jenisTransmisi = jenisTransmisi;
    }

    public String getJenisTransmisi() {
        return jenisTransmisi;
    }

    public void setJenisTransmisi(String jenisTransmisi) {
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void tampilInfo() {
        System.out.printf(java.util.Locale.US, "[MOTOR] Kode: %-5s | Nama: %-15s | Transmisi: %-5s | Tarif: Rp%,.0f/hari | Status: %s\n",
                getKodeKendaraan(), getNamaKendaraan(), jenisTransmisi, getHargaSewaPerHari(), isTersedia() ? "Tersedia" : "Disewa");
    }

    @Override
    public double hitungBiayaDasar(int lamaSewa) {
        double total = super.hitungBiayaDasar(lamaSewa);
        if (jenisTransmisi.equalsIgnoreCase("Matik")) {
            total += (10000 * lamaSewa);
        }
        return total;
    }
}
