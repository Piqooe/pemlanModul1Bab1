package tugas_praktikum.pertemuan_1;

public class Mobil {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private double kecepatan;
    private double waktu;

    public void setNoPlat(String s) {
        noPlat = s;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setManufaktur(String s) {
        manufaktur = s;
    }

    public void setKecepatan(int i) {
        this.kecepatan = rubahKecepatan(i);
    }

    private double rubahKecepatan(double kmh) {
        return kmh / 3.6;
    }

    public void setWaktu(double w) {
        this.waktu = rubahSekon(w);
    }

    private double rubahSekon(double jam) {
        return jam * 3600;
    }

    public void displayMessage() {
        System.out.println("Mobil anda adalah bermerek " + manufaktur);
        System.out.println("mempunyai nomor plat " + noPlat);
        System.out.println("serta memililki warna " + warna);
        System.out.println("dan mampu menempuh kecepatan " + String.format("%.2f", kecepatan) + " m/s");
        System.out.println("Waktu tempuh : " + String.format("%.2f", waktu) + " sekon");
    }
}