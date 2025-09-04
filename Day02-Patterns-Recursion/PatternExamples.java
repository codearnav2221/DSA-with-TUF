public class PatternExamples {
    public static void main(String[] args) {
        int n = 5;

        // Pattern 1: Solid square
        System.out.println("Pattern 1: Solid Square");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 2: Right-angled triangle
        System.out.println("\nPattern 2: Right-angled Triangle");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Pattern 3: Inverted triangle
        System.out.println("\nPattern 3: Inverted Triangle");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
