import java.util.Arrays;

public class PermutationCirculaire {

    public static boolean estPermutationCirculaire(int[] t) {
        if (t == null || t.length == 0) {
            return false;
        }

        int n = t.length;
 
        boolean[] vu = new boolean[n + 1];
        int pos1 = -1;

        for (int i = 0; i < n; i++) {
            int val = t[i];

            if (val < 1 || val > n) {
                return false;
            }

            if (vu[val]) {
                return false;
            }

            vu[val] = true;
 
            if (val == 1) {
                pos1 = i;
            }
        }

        if (pos1 == -1) {
            return false;
        }

        for (int k = 0; k < n; k++) {
            int idx = (pos1 + k) % n;
            int valeurAttendue = k + 1;

            if (t[idx] != valeurAttendue) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Cas de base ===");
        tester(new int[]{1});
        tester(new int[]{1, 2, 3, 4, 5});

        System.out.println("\n=== 2. Rotations valides (n=5) ===");
        tester(new int[]{2, 3, 4, 5, 1});
        tester(new int[]{3, 4, 5, 1, 2});
        tester(new int[]{4, 5, 1, 2, 3});
        tester(new int[]{5, 1, 2, 3, 4});

        System.out.println("\n=== 3. Permutations non circulaires (n=5) ===");
        tester(new int[]{3, 1, 2, 4, 5});
        tester(new int[]{2, 1, 3, 4, 5});
        tester(new int[]{4, 1, 2, 3, 5});

        System.out.println("\n=== 4. Valeurs hors de 1..n ou doublons ===");
        tester(new int[]{0, 1, 2, 3, 4});
        tester(new int[]{1, 2, 2, 3, 4});
        tester(new int[]{1, 2, 3, 4, 6});

        System.out.println("\n=== 5. Cas limites ===");
        tester(new int[]{});
    }

    private static void tester(int[] t) {
        System.out.println(Arrays.toString(t) + " -> " + estPermutationCirculaire(t));
    }
}