import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {

    public static void afficherElementsManquants(int[] t) {
        if (t == null || t.length == 0) {
            System.out.println("Aucun élément manquant (tableau vide)");
            return;
        }

        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }
        boolean trouve = false;
        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.print("Aucun élément manquant");
        }
        System.out.println();
    }

    public static List<Integer> trouverElementsManquants(int[] t) {
        List<Integer> manquants = new ArrayList<>();
        if (t == null || t.length == 0) return manquants;

        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                manquants.add(k);
            }
        }
        return manquants;
    }
    public static void afficherElementsManquantsInPlace(int[] t) {
        if (t == null || t.length == 0) return;
        int n = t.length;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(t[i]);
            if (val >= 1 && val <= n) {
                if (t[val - 1] > 0) {
                    t[val - 1] = -t[val - 1];
                }
            }
        }

        boolean trouve = false;
        for (int i = 0; i < n; i++) {
            if (t[i] > 0) {
                System.out.print((i + 1) + " ");
                trouve = true;
            }
        }
        if (!trouve) System.out.print("Aucun élément manquant");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Jeux de tests ===");

        
        System.out.print("t1 [1, 3, 3, 5] (n=4) -> ");
        afficherElementsManquants(new int[]{1, 3, 3, 5}); 
        
        System.out.print("t2 [1, 2, 3, 4] -> ");
        afficherElementsManquants(new int[]{1, 2, 3, 4}); 
        System.out.print("t3 [3, 3, 3] -> ");
        afficherElementsManquants(new int[]{3, 3, 3}); 
        System.out.print("t4 [1, 1, 1, 1] -> ");
        afficherElementsManquants(new int[]{1, 1, 1, 1}); 
        System.out.print("t5 [4, 2, 2, 1, 5] -> ");
        afficherElementsManquants(new int[]{4, 2, 2, 1, 5}); 

        System.out.print("t6 [] -> ");
        afficherElementsManquants(new int[]{});

        System.out.print("t7 [1, 2, 3, 6] (n=4 avec valeur invalide) -> ");
        afficherElementsManquants(new int[]{1, 2, 3, 6}); 
    }
}