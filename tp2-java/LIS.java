public class LIS {

    
    public static int longueurLIS(int[] t) {
        if (t == null || t.length == 0) {
            return 0;
        }

        int n = t.length;
        int[] dp = new int[n];

    
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (t[j] < t[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int reponse = 0;
        for (int i = 0; i < n; i++) {
            reponse = Math.max(reponse, dp[i]);
        }

        return reponse;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {},                            // tableau vide -> 0
            {5},                           // un seul élément -> 1
            {5, 4, 3, 2, 1},               // strictement décroissant -> 1
            {1, 2, 3, 4, 5},               // strictement croissant -> 5
            {2, 1, 4, 2, 3, 5, 1, 7},       // exemple donné -> 5
            {3, 3, 3, 3},                  // tous égaux -> 1
            {10, 9, 2, 5, 3, 7, 101, 18}   // exemple classique -> 4
        };

        for (int[] t : tests) {
            System.out.println("LIS = " + longueurLIS(t));
        }
    }
}