package tugas_praktikum.pemlanModulBab10;

import java.io.File;
import java.util.Scanner;

public class UkuranFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama/path file (misal: test.txt): ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            long bytes = file.length();
            double kilobytes = bytes / 1024.0;
            double megabytes = kilobytes / 1024.0;

            if (megabytes < 1) {
                System.out.printf("Ukuran file: %.2f KB%n", kilobytes);
            } else {
                System.out.printf("Ukuran file: %.2f MB%n", megabytes);
            }
        } else {
            System.out.println("File tidak ditemukan!");
        }
        
        scanner.close();
    }
}
