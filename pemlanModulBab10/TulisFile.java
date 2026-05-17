package tugas_praktikum.pemlanModulBab10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TulisFile {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);
        System.out.print("Masukkan teks yang akan disimpan: ");
        var text = keyboard.nextLine();
        try (var writer = new FileWriter("test.txt", true)) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file");
        }
    }
}
