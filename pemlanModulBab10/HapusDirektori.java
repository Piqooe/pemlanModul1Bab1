package tugas_praktikum.pemlanModulBab10;

import java.io.File;
import java.util.Scanner;

public class HapusDirektori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan path direktori yang ingin dihapus: ");
        String pathDirektori = scanner.nextLine();

        File direktori = new File(pathDirektori);

        if (direktori.exists() && direktori.isDirectory()) {
            File[] isiDirektori = direktori.listFiles();
            
            if (isiDirektori != null) {
                for (File file : isiDirektori) {
                    file.delete();
                }
            }
            
            if (direktori.delete()) {
                System.out.println("Direktori dan seluruh file di dalamnya berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus direktori.");
            }
        } else {
            System.out.println("Direktori tidak ditemukan atau path yang dimasukkan salah.");
        }

        scanner.close();
    }
}
