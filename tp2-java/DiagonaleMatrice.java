public class DiagonaleMatrice {

    public static int differenceDiagonales(int[][] m) {
        
        if (m == null || m.length == 0) {
            System.out.println("Matrice invalide ou vide.");
            return 0;
        }

        int n = m.length;
        int sommePrincipale = 0;
        int sommeSecondaire = 0;
        
        for (int i = 0; i < n; i++) {
            sommePrincipale += m[i][i];            
            sommeSecondaire += m[i][n - 1 - i];    
        }

        int diffAbsolue = Math.abs(sommePrincipale - sommeSecondaire);

        System.out.println("Diagonale principale : " + sommePrincipale);
        System.out.println("Diagonale secondaire : " + sommeSecondaire);
        System.out.println("Différence absolue   : " + diffAbsolue);
        System.out.println("-----------------------------------");

        return diffAbsolue;
    }

    public static void main(String[] args) {
        System.out.println("=== 6. Jeux de tests ===\n");

        // 1. Matrice 3 x 3 simple
        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test 1 (Matrice 3x3 simple) :");
        differenceDiagonales(m1); 
        int[][] m2 = {
            {1, 3, 5},
            {2, 4, 6},
            {7, 8, 9}
        };
        System.out.println("Test 2 (Valeurs variées) :");
        differenceDiagonales(m2); 
        int[][] m3 = {
            {5}
        };
        System.out.println("Test 3 (Matrice 1x1) :");
        differenceDiagonales(m3); 
        int[][] m4 = {
            {-1,  2},
            { 3, -4}
        };
        System.out.println("Test 4 (Valeurs négatives) :");
        differenceDiagonales(m4); 
    }
}