import java.util.ArrayList;
import java.util.List;

public class Pivots {

    
    public static void afficherPivots(int[] t) {
        if (t == null || t.length < 3) {
            System.out.println("Aucun pivot");
            return;
        }

        int n = t.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        
        prefixMax[0] = t[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], t[i]);
        }

        suffixMin[n - 1] = t[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], t[i]);
        }


        List<Integer> pivots = new ArrayList<>();
        for (int i = 1; i <= n - 2; i++) {
            if (prefixMax[i - 1] <= t[i] && suffixMin[i + 1] >= t[i]) {
                pivots.add(t[i]);
            }
        }

        if (pivots.isEmpty()) {
            System.out.println("Aucun pivot");
        } else {
            System.out.print("Pivots : ");
            for (int p : pivots) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
 
        int[] t1 = {2, 4, 3, 5, 6};
        int[] t2 = {1, 2, 3, 4, 5};
        int[] t3 = {5, 4, 3, 2, 1};
        int[] t4 = {3, 3, 3, 3};
        int[] t5 = {7, 1, 5, 2, 6, 3, 4};

        System.out.print("t1 -> ");
        afficherPivots(t1); 

        System.out.print("t2 -> ");
        afficherPivots(t2); 

        System.out.print("t3 -> ");
        afficherPivots(t3); 

        System.out.print("t4 -> ");
        afficherPivots(t4); 
        System.out.print("t5 -> ");
        afficherPivots(t5); 
    }
}