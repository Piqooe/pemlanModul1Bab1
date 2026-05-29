package tugas_praktikum.uap;

import java.util.ArrayList;

public class GoDriveRentalSystem {
    private ArrayList<Kendaraan> daftarKendaraan;

    public GoDriveRentalSystem() {
        daftarKendaraan = new ArrayList<>();
    }

    public void tambahKendaraan(Kendaraan k) {
        daftarKendaraan.add(k);
    }

    public void tampilkanDaftarKendaraan() {
        System.out.println("\n=== DAFTAR ARMADA GODRIVE ===");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarKendaraan.get(i).tampilInfo();
        }
    }

    public void sewaKendaraan(String kode, int lamaSewa, boolean isVip) throws KendaraanTidakTersediaException {
        Kendaraan k = null;
        for (Kendaraan kendaraan : daftarKendaraan) {
            if (kendaraan.getKodeKendaraan().equalsIgnoreCase(kode)) {
                k = kendaraan;
                break;
            }
        }

        if (k == null || !k.isTersedia()) {
            throw new KendaraanTidakTersediaException("Kendaraan dengan kode " + kode + " gagal disewa. Alasan: Kendaraan sedang disewa atau tidak ditemukan!");
        }

        k.setTersedia(false);

        double biayaDasar = k.getHargaSewaPerHari() * lamaSewa;
        double totalBiaya = k.hitungBiayaDasar(lamaSewa);
        double tambahan = totalBiaya - biayaDasar;
        
        System.out.println("\n=== TRANSAKSI SEWA GODRIVE ===");
        System.out.println("Kendaraan Berhasil Disewa!");
        System.out.println("Unit             : " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ")");
        System.out.println("Lama Sewa        : " + lamaSewa + " hari");
        System.out.printf(java.util.Locale.US, "Biaya Dasar Harian : Rp %,.0f\n", biayaDasar);
        
        if (k instanceof Mobil && ((Mobil) k).getJumlahKursi() > 5) {
            System.out.printf(java.util.Locale.US, "Tambahan Kursi (>5): Rp %,.0f\n", tambahan);
        } else if (k instanceof Motor && ((Motor) k).getJenisTransmisi().equalsIgnoreCase("Matik")) {
            System.out.printf(java.util.Locale.US, "Tambahan Asuransi  : Rp %,.0f\n", tambahan);
        }

        double totalDiskon = 0;
        if (isVip) {
            double diskonVIP = totalBiaya * 0.10;
            totalDiskon += diskonVIP;
            System.out.printf(java.util.Locale.US, "Diskon Member VIP (10%%): -Rp %,.0f\n", diskonVIP);
        }

        if (lamaSewa > 7) {
            double diskonLama = totalBiaya * 0.05;
            totalDiskon += diskonLama;
            System.out.printf(java.util.Locale.US, "Diskon Lama Sewa > 7 hari (5%%): -Rp %,.0f\n", diskonLama);
        }

        double biayaAkhir = totalBiaya - totalDiskon;
        System.out.println("------------------------------");
        System.out.printf(java.util.Locale.US, "TOTAL BIAYA AKHIR: Rp %,.0f\n", biayaAkhir);
    }

    public void sewaKendaraan(String kode, int lamaSewa) throws KendaraanTidakTersediaException {
        sewaKendaraan(kode, lamaSewa, false);
    }

    public void kembalikanKendaraan(String kode) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getKodeKendaraan().equalsIgnoreCase(kode)) {
                if (!k.isTersedia()) {
                    k.setTersedia(true);
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ") berhasil dikembalikan. Status: Tersedia.");
                } else {
                    System.out.println("[INFO] Kendaraan " + k.getNamaKendaraan() + " (" + k.getKodeKendaraan() + ") sudah dalam status tersedia (tidak sedang disewa).");
                }
                return;
            }
        }
        System.out.println("[ERROR] Kendaraan dengan kode " + kode + " tidak ditemukan.");
    }
}
