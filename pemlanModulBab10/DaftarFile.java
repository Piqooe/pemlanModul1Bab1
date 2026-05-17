package tugas_praktikum.pemlanModulBab10;

import java.io.File;
import java.util.Scanner;

public class DaftarFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan path direktori (contoh: src/): ");
        String pathDirektori = scanner.nextLine();

        File direktori = new File(pathDirektori);

        if (direktori.exists() && direktori.isDirectory()) {
            File[] isiDirektori = direktori.listFiles();

            System.out.println("\nDaftar file dalam direktori " + direktori.getName() + ":");
            
            if (isiDirektori != null && isiDirektori.length > 0) {
                for (File file : isiDirektori) {
                    if (file.isFile()) {
                        System.out.println("- [File]   " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("- [Folder] " + file.getName());
                    }
                }
            } else {
                System.out.println("(Direktori kosong)");
            }
        } else {
            System.out.println("Error: Direktori tidak ditemukan atau path yang dimasukkan bukan sebuah folder!");
        }

        scanner.close();
    }
}
