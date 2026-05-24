package tugas_praktikum.pemlanModulBab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Player {
    int no;
    int tinggiBadan;
    int beratBadan;
    String tim;

    public Player(int no, int tinggiBadan, int beratBadan, String tim) {
        this.no = no;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.tim = tim;
    }

    @Override
    public String toString() {
        return String.format("No: %2d | Tim: %s | Tinggi: %3d cm | Berat: %3d kg", no, tim, tinggiBadan, beratBadan);
    }
}

public class SortingSearchingApp {

    public static void main(String[] args) {
        ArrayList<Player> timA = new ArrayList<>();
        ArrayList<Player> timB = new ArrayList<>();

        timA.add(new Player(1, 168, 50, "A"));
        timA.add(new Player(2, 170, 60, "A"));
        timA.add(new Player(3, 165, 56, "A"));
        timA.add(new Player(4, 168, 55, "A"));
        timA.add(new Player(5, 172, 60, "A"));
        timA.add(new Player(6, 170, 70, "A"));
        timA.add(new Player(7, 169, 66, "A"));
        timA.add(new Player(8, 165, 56, "A"));
        timA.add(new Player(9, 171, 72, "A"));
        timA.add(new Player(10, 166, 56, "A"));

        timB.add(new Player(1, 170, 66, "B"));
        timB.add(new Player(2, 167, 60, "B"));
        timB.add(new Player(3, 165, 59, "B"));
        timB.add(new Player(4, 166, 58, "B"));
        timB.add(new Player(5, 168, 58, "B"));
        timB.add(new Player(6, 175, 71, "B"));
        timB.add(new Player(7, 172, 68, "B"));
        timB.add(new Player(8, 171, 68, "B"));
        timB.add(new Player(9, 168, 65, "B"));
        timB.add(new Player(10, 169, 60, "B"));

        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(timA);
        allPlayers.addAll(timB);

        System.out.println("========== BAGIAN 1: SORTING DAN COPY ==========");

        System.out.println("\n--- 1.a Urut Tinggi Badan Ascending (Seluruh Pemain) ---");
        allPlayers.sort(Comparator.comparingInt(p -> p.tinggiBadan));
        printList(allPlayers);

        System.out.println("\n--- 1.a Urut Tinggi Badan Descending (Seluruh Pemain) ---");
        allPlayers.sort((p1, p2) -> Integer.compare(p2.tinggiBadan, p1.tinggiBadan));
        printList(allPlayers);

        System.out.println("\n--- 1.b Urut Berat Badan Ascending (Seluruh Pemain) ---");
        allPlayers.sort(Comparator.comparingInt(p -> p.beratBadan));
        printList(allPlayers);

        System.out.println("\n--- 1.b Urut Berat Badan Descending (Seluruh Pemain) ---");
        allPlayers.sort((p1, p2) -> Integer.compare(p2.beratBadan, p1.beratBadan));
        printList(allPlayers);

        System.out.println("\n--- 1.c Nilai Maksimum dan Minimum Tim ---");
        Player minTinggiA = Collections.min(timA, Comparator.comparingInt(p -> p.tinggiBadan));
        Player maxTinggiA = Collections.max(timA, Comparator.comparingInt(p -> p.tinggiBadan));
        Player minBeratA = Collections.min(timA, Comparator.comparingInt(p -> p.beratBadan));
        Player maxBeratA = Collections.max(timA, Comparator.comparingInt(p -> p.beratBadan));

        System.out.println("Tim A -> Tinggi Minimal : " + minTinggiA.tinggiBadan + " cm, Maksimal : "
                + maxTinggiA.tinggiBadan + " cm");
        System.out.println("Tim A -> Berat Minimal  : " + minBeratA.beratBadan + " kg, Maksimal : "
                + maxBeratA.beratBadan + " kg");

        Player minTinggiB = Collections.min(timB, Comparator.comparingInt(p -> p.tinggiBadan));
        Player maxTinggiB = Collections.max(timB, Comparator.comparingInt(p -> p.tinggiBadan));
        Player minBeratB = Collections.min(timB, Comparator.comparingInt(p -> p.beratBadan));
        Player maxBeratB = Collections.max(timB, Comparator.comparingInt(p -> p.beratBadan));

        System.out.println("Tim B -> Tinggi Minimal : " + minTinggiB.tinggiBadan + " cm, Maksimal : "
                + maxTinggiB.tinggiBadan + " cm");
        System.out.println("Tim B -> Berat Minimal  : " + minBeratB.beratBadan + " kg, Maksimal : "
                + maxBeratB.beratBadan + " kg");

        System.out.println("\n--- 1.d Copy seluruh anggota Tim B ke Tim C ---");
        ArrayList<Player> timC = new ArrayList<>();
        for (Player p : timB) {
            timC.add(new Player(p.no, p.tinggiBadan, p.beratBadan, "C"));
        }
        System.out.println("Isi Tim C (Hasil Copy dari Tim B):");
        printList(timC);

        System.out.println("\n========== BAGIAN 2: BINARY SEARCH ==========");

        timB.sort(Comparator.comparingInt(p -> p.tinggiBadan));
        System.out.println("\n--- 2.b Pencarian Tinggi di Tim B ---");
        System.out.println("Jumlah pemain Tim B dengan tinggi 168 cm: " + countOccurrences(timB, 168, true));
        System.out.println("Jumlah pemain Tim B dengan tinggi 160 cm: " + countOccurrences(timB, 160, true));

        timA.sort(Comparator.comparingInt(p -> p.beratBadan));
        System.out.println("\n--- 2.c Pencarian Berat di Tim A ---");
        System.out.println("Jumlah pemain Tim A dengan berat 56 kg: " + countOccurrences(timA, 56, false));
        System.out.println("Jumlah pemain Tim A dengan berat 53 kg: " + countOccurrences(timA, 53, false));

        System.out.println("\n--- 2.d Pengecekan Kesamaan Pemain Tim A dengan Tim B ---");
        checkSimilarities(timA, timB);
    }

    private static void printList(ArrayList<Player> list) {
        for (Player p : list) {
            System.out.println(p);
        }
    }

    private static int countOccurrences(ArrayList<Player> list, int target, boolean isHeightSearch) {
        int firstIdx = findFirstOccurrence(list, target, isHeightSearch);
        if (firstIdx == -1) {
            return 0;
        }
        int lastIdx = findLastOccurrence(list, target, isHeightSearch);
        return lastIdx - firstIdx + 1;
    }

    private static int findFirstOccurrence(ArrayList<Player> list, int target, boolean isHeightSearch) {
        int left = 0, right = list.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = isHeightSearch ? list.get(mid).tinggiBadan : list.get(mid).beratBadan;

            if (midVal == target) {
                result = mid;
                right = mid - 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int findLastOccurrence(ArrayList<Player> list, int target, boolean isHeightSearch) {
        int left = 0, right = list.size() - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = isHeightSearch ? list.get(mid).tinggiBadan : list.get(mid).beratBadan;

            if (midVal == target) {
                result = mid;
                left = mid + 1;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static void checkSimilarities(ArrayList<Player> timA, ArrayList<Player> timB) {
        boolean foundAny = false;

        timB.sort(Comparator.comparingInt(p -> p.tinggiBadan));
        for (Player pA : timA) {
            if (binarySearchExists(timB, pA.tinggiBadan, true)) {
                System.out.println("Pemain Tim A No." + pA.no + " (Tinggi: " + pA.tinggiBadan
                        + " cm) memiliki tinggi badan yang sama dengan pemain di Tim B.");
                foundAny = true;
            }
        }

        timB.sort(Comparator.comparingInt(p -> p.beratBadan));
        for (Player pA : timA) {
            if (binarySearchExists(timB, pA.beratBadan, false)) {
                System.out.println("Pemain Tim A No." + pA.no + " (Berat: " + pA.beratBadan
                        + " kg) memiliki berat badan yang sama dengan pemain di Tim B.");
                foundAny = true;
            }
        }

        if (!foundAny) {
            System.out.println(
                    "Tidak ada pemain di Tim A yang memiliki tinggi atau berat badan yang sama dengan pemain di Tim B.");
        }
    }

    private static boolean binarySearchExists(ArrayList<Player> list, int target, boolean isHeightSearch) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = isHeightSearch ? list.get(mid).tinggiBadan : list.get(mid).beratBadan;
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
