public class MatriceMagique {

    
    public static boolean estCarreMagique(int[][] m) {
        if (m == null || m.length != 3) return false;
    
        int ref = m[0][0] + m[0][1] + m[0][2];

        if ((m[1][0] + m[1][1] + m[1][2]) != ref) return false;
        if ((m[2][0] + m[2][1] + m[2][2]) != ref) return false;

        if ((m[0][0] + m[1][0] + m[2][0]) != ref) return false;
        if ((m[0][1] + m[1][1] + m[2][1]) != ref) return false;
        if ((m[0][2] + m[1][2] + m[2][2]) != ref) return false;

        if ((m[0][0] + m[1][1] + m[2][2]) != ref) return false; 
        if ((m[0][2] + m[1][1] + m[2][0]) != ref) return false; 

        return true;
    }

    public static void testerEtAfficher(int[][] m) {
        if (estCarreMagique(m)) {
            System.out.println("Carré magique");
        } else {
            System.out.println("Pas un carré magique");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 6. Jeux de tests ===\n");

        
        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };
        System.out.print("Test 1 (Carré magique classique) -> ");
        testerEtAfficher(m1); 
        
        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };
        System.out.print("Test 2 (Non magique) -> ");
        testerEtAfficher(m2); 
        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.print("Test 3 (Valeurs identiques) -> ");
        testerEtAfficher(m3); 
        int[][] m4 = {
            { 0,  5, -2},
            {-3,  1,  5},
            { 4, -3,  2}
        };
        System.out.print("Test 4 (Valeurs négatives) -> ");
        testerEtAfficher(m4);
    }
}