import java.util.Stack;

public class MaxRectangle {

    public static class Rectangle {
        public int top;
        public int left;
        public int bottom;
        public int right;
        public int area;

        public Rectangle() {
            this.top = 0;
            this.left = 0;
            this.bottom = 0;
            this.right = 0;
            this.area = 0;
        }

        public Rectangle(int top, int left, int bottom, int right, int area) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
            this.area = area;
        }

        public String toString() {
            if (area == 0) {
                return "Aire maximale = 0 (aucun rectangle de 1)";
            }
            return "Aire = " + area + " [top=" + top + ", left=" + left + 
                   ", bottom=" + bottom + ", right=" + right + "]";
        }
    }

    public static int maxRectangle(int[][] m) {
        Rectangle r = trouverMaxRectangle(m);
        return r != null ? r.area : 0;
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return new Rectangle();
        }

        int R = m.length;
        int C = m[0].length;
        int[][] h = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (m[i][j] == 0) {
                    h[i][j] = 0;
                } else {
                    h[i][j] = (i == 0) ? 1 : h[i - 1][j] + 1;
                }
            }
        }

        Rectangle maxRect = new Rectangle();

        for (int i = 0; i < R; i++) {
            Stack<Integer> stack = new Stack<>();
            int j = 0;

            while (j <= C) {
                int height = (j == C) ? 0 : h[i][j];

                if (stack.isEmpty() || height >= h[i][stack.peek()]) {
                    stack.push(j);
                    j++;
                } else {
                    int tp = stack.pop();
                    int hVal = h[i][tp];
                    int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                    int rightBoundary = j - 1;
                    int currentArea = hVal * (rightBoundary - leftBoundary + 1);

                    if (currentArea > maxRect.area) {
                        maxRect.area = currentArea;
                        maxRect.bottom = i;
                        maxRect.top = i - hVal + 1;
                        maxRect.left = leftBoundary;
                        maxRect.right = rightBoundary;
                    }
                }
            }
        }

        return maxRect;
    }

    public static void main(String[] args) {
    
        System.out.println("=== Test 1: Matrice 4x5 du sujet ===");
        int[][] m1 = {
            {0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 0, 1}
        };
        System.out.println(trouverMaxRectangle(m1));

        System.out.println("\n=== Test 2: Cas simples (1x1) ===");
        int[][] m2_a = {{0}};
        int[][] m2_b = {{1}};
        System.out.println("[0] -> " + trouverMaxRectangle(m2_a));
        System.out.println("[1] -> " + trouverMaxRectangle(m2_b));

        System.out.println("\n=== Test 3: Bloc central ===");
        int[][] m3 = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };
        System.out.println(trouverMaxRectangle(m3));

        System.out.println("\n=== Test 4: Tout à 1 (3x3) ===");
        int[][] m4 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        System.out.println(trouverMaxRectangle(m4));

        System.out.println("\n=== Test 5: Tout à 0 (3x3) ===");
        int[][] m5 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        System.out.println(trouverMaxRectangle(m5));
    }
}