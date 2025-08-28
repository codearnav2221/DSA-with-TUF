public class TimeComplexityExamples {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // O(1): Constant time
        System.out.println("First element: " + arr[0]);

        // O(n): Linear time
        System.out.print("Array elements: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // O(n^2): Quadratic time
        System.out.println("All pairs:");
        for (int i : arr) {
            for (int j : arr) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
    }
}
