import java.util.*;

public class RecursionAdvanced {

    // 1. Print all subsequences of an array
    public static void printSubsequences(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }
        // Include current element
        current.add(arr[index]);
        printSubsequences(arr, index + 1, current);

        // Exclude current element
        current.remove(current.size() - 1);
        printSubsequences(arr, index + 1, current);
    }

    // 2. Print all subsets of a string
    public static void printSubsets(String s, String current, int index) {
        if (index == s.length()) {
            System.out.println(current);
            return;
        }
        // Include char
        printSubsets(s, current + s.charAt(index), index + 1);
        // Exclude char
        printSubsets(s, current, index + 1);
    }

    // 3. Power function (x^n)
    public static int power(int x, int n) {
        if (n == 0) return 1; // base case
        return x * power(x, n - 1);
    }

    // 4. Generate all permutations of a string
    public static void printPermutations(String s, String current) {
        if (s.length() == 0) {
            System.out.println(current);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i + 1);
            printPermutations(rest, current + ch);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Subsequences of array:");
        printSubsequences(arr, 0, new ArrayList<>());

        System.out.println("\nSubsets of string:");
        printSubsets("abc", "", 0);

        int x = 2, n = 5;
        System.out.println("\nPower(" + x + "^" + n + ") = " + power(x, n));

        System.out.println("\nPermutations of string:");
        printPermutations("abc", "");
    }
}
