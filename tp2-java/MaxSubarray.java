import java.util.Arrays;

public class MaxSubarray {

    
    public static int maxSubarraySum(int[] t) {
        if (t == null || t.length == 0) {
            return 0;
        }

        int currentSum = t[0];
        int maxSum = t[0];

        for (int i = 1; i < t.length; i++) {
            currentSum = Math.max(t[i], currentSum + t[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void maxSubarrayDetail(int[] t) {
        if (t == null || t.length == 0) {
            System.out.println("Tableau vide");
            return;
        }

        int currentSum = t[0];
        int maxSum = t[0];

        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < t.length; i++) {
            if (t[i] > currentSum + t[i]) {
                currentSum = t[i];
                start = i;
            } else {
                currentSum += t[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }

        System.out.print("Entrée: " + Arrays.toString(t));
        System.out.println(" -> Somme maximale = " + maxSum);
        System.out.print("Sous-suite: [");
        for (int k = bestStart; k <= bestEnd; k++) {
            System.out.print(t[k] + (k < bestEnd ? ", " : ""));
        }
        System.out.println("] (de l'indice " + bestStart + " à " + bestEnd + ")\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Tests maxSubarraySum ===");

        int[] t1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("t1 -> " + maxSubarraySum(t1)); // Attendu: 6
        int[] t2 = {1, 2, 3, 4};
        System.out.println("t2 -> " + maxSubarraySum(t2)); // Attendu: 10
        int[] t3 = {-1, -2, -3};
        System.out.println("t3 -> " + maxSubarraySum(t3)); // Attendu: -1
        int[] t4 = {5};
        int[] t5 = {-7};
        System.out.println("t4 -> " + maxSubarraySum(t4)); // Attendu: 5
        System.out.println("t5 -> " + maxSubarraySum(t5)); // Attendu: -7
        int[] t6 = {-2, -1, 3, 4, -5};
        System.out.println("t6 -> " + maxSubarraySum(t6)); // Attendu: 7
        int[] t7 = {1, -1, 1, -1, 1};
        System.out.println("t7 -> " + maxSubarraySum(t7)); // Attendu: 1

        System.out.println("\n=== Tests Extension avec affichage du sous-tableau ===");
        maxSubarrayDetail(t1);
        maxSubarrayDetail(t3);
        maxSubarrayDetail(t6);
    }
}