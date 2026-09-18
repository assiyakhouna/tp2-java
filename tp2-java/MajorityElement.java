import java.util.Arrays;

public class MajorityElement {

    public static int elementMajoritaire(int[] t) {

        if (t == null || t.length == 0) {
            return -1;
        }

        int candidat = 0;
        int compteur = 0;

        for (int x : t) {
            if (compteur == 0) {
                candidat = x;
                compteur = 1;
            } else if (x == candidat) {
                compteur++;
            } else {
                compteur--;
            }
        }
        int occurrences = 0;
        for (int x : t) {
            if (x == candidat) {
                occurrences++;
            }
        }

        if (occurrences > t.length / 2) {
            return candidat;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== 7. Jeux de tests ===");

        System.out.println(elementMajoritaire(new int[]{3, 3, 4, 3, 5}));       // Attendu: 3
        System.out.println(elementMajoritaire(new int[]{2, 2, 1, 2, 3, 2, 2})); // Attendu: 2
        System.out.println(elementMajoritaire(new int[]{1, 1, 1, 1}));          // Attendu: 1
        System.out.println(elementMajoritaire(new int[]{7}));                   // Attendu: 7

        System.out.println(elementMajoritaire(new int[]{1, 2, 3, 4}));          // Attendu: -1
        System.out.println(elementMajoritaire(new int[]{1, 2, 2, 3}));          // Attendu: -1
        System.out.println(elementMajoritaire(new int[]{1, 1, 2, 2}));          // Attendu: -1

        System.out.println(elementMajoritaire(new int[]{-1, -1, -1, 2, 3}));    // Attendu: -1
        System.out.println(elementMajoritaire(new int[]{-2, 2, 2, 2, 1, 1}));   // Attendu: 2

        System.out.println(elementMajoritaire(new int[]{}));                    // Attendu: -1
        System.out.println(elementMajoritaire(new int[]{10}));                  // Attendu: 10
    }
}