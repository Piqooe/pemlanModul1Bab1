package tugas_praktikum.uap;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GoDriveRentalSystem system = new GoDriveRentalSystem();

    public static void main(String[] args) {
        initData();
        int menu = 0;
        do {
            System.out.println("\n====== MENU GO DRIVE RENTAL SYSTEM ======");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Tampilkan Daftar Armada");
            System.out.println("3. Sewa Kendaraan");
            System.out.println("4. Kembalikan Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            try {
                menu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!");
                continue;
            }

            switch (menu) {
                case 1:
                    menuTambah();
                    break;
                case 2:
                    system.tampilkanDaftarKendaraan();
                    break;
                case 3:
                    menuSewa();
                    break;
                case 4:
                    menuKembali();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan layanan GoDrive!");
                    break;
                default:
                    System.out.println("Menu tidak tersedia!");
            }
        } while (menu != 5);
    }

    private static void initData() {
        system.tambahKendaraan(new Mobil("MBL01", "Toyota Avanza", 350000, 7));
        system.tambahKendaraan(new Mobil("MBL02", "Daihatsu Sigra", 300000, 7));
        system.tambahKendaraan(new Mobil("MBL03", "Honda Brio", 280000, 5));
        system.tambahKendaraan(new Motor("MTR01", "Honda Vario", 80000, "Matik"));
        system.tambahKendaraan(new Motor("MTR02", "Yamaha NMAX", 100000, "Matik"));
        system.tambahKendaraan(new Motor("MTR03", "Kawasaki KLX", 90000, "Manual"));
    }

    private static void menuTambah() {
        System.out.print("Masukkan jenis kendaraan (mobil/motor): ");
        String jenis = scanner.nextLine().trim();
        
        System.out.print("Masukkan kode kendaraan: ");
        String kode = scanner.nextLine().trim();
        
        System.out.print("Masukkan nama kendaraan: ");
        String nama = scanner.nextLine().trim();
        
        System.out.print("Masukkan harga sewa per hari: ");
        double harga = Double.parseDouble(scanner.nextLine().trim());
        
        if (jenis.equalsIgnoreCase("mobil")) {
            System.out.print("Masukkan kapasitas kursi: ");
            int kursi = Integer.parseInt(scanner.nextLine().trim());
            system.tambahKendaraan(new Mobil(kode, nama, harga, kursi));
            System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + nama + " (" + kode + ")");
        } else if (jenis.equalsIgnoreCase("motor")) {
            System.out.print("Masukkan jenis transmisi (Matik/Manual): ");
            String transmisi = scanner.nextLine().trim();
            system.tambahKendaraan(new Motor(kode, nama, harga, transmisi));
            System.out.println("[INFO] Kendaraan berhasil ditambahkan: " + nama + " (" + kode + ")");
        } else {
            System.out.println("[ERROR] Jenis kendaraan tidak valid.");
        }
    }

    private static void menuSewa() {
        System.out.print("Masukkan kode kendaraan yang ingin disewa: ");
        String kode = scanner.nextLine().trim();
        
        System.out.print("Masukkan durasi sewa (dalam hari): ");
        int durasi = Integer.parseInt(scanner.nextLine().trim());
        
        System.out.print("Apakah Anda Member VIP? (y/n): ");
        String vipInput = scanner.nextLine().trim();
        boolean isVip = vipInput.equalsIgnoreCase("y");
        
        try {
            system.sewaKendaraan(kode, durasi, isVip);
        } catch (KendaraanTidakTersediaException e) {
            e.printStackTrace(System.out);
        }
    }

    private static void menuKembali() {
        System.out.print("Masukkan kode kendaraan yang ingin dikembalikan: ");
        String kode = scanner.nextLine().trim();
        system.kembalikanKendaraan(kode);
    }
}
