public class RecursionBasics {

    // Print 1 to N
    public static void printOneToN(int n) {
        if (n == 0) return;   // base case
        printOneToN(n - 1);   // recursive call
        System.out.print(n + " ");
    }

    // Print N to 1
    public static void printNToOne(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNToOne(n - 1);
    }

    // Sum of first N numbers
    public static int sumOfN(int n) {
        if (n == 0) return 0;
        return n + sumOfN(n - 1);
    }

    // Reverse array using recursion
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) return;  // base case
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.print("Print 1 to " + n + ": ");
        printOneToN(n);
        System.out.println();

        System.out.print("Print " + n + " to 1: ");
        printNToOne(n);
        System.out.println();

        System.out.println("Sum of first " + n + " numbers: " + sumOfN(n));

        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("Original array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        reverseArray(arr, 0, arr.length - 1);

        System.out.print("Reversed array: ");
        for (int num : arr) System.out.print(num + " ");
    }
}
