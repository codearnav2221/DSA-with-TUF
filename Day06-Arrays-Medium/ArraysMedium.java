import java.util.*;

public class ArraysMedium {

    // Left rotate array by d places
    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    // Right rotate array by d places
    public static void rightRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - d - 1);
        reverse(arr, 0, n - 1);
    }

    // Helper function to reverse part of array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Move all zeroes to the end
    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int index = 0;
        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }
    }

    // Union of two arrays
    public static Set<Integer> union(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr1) set.add(num);
        for (int num : arr2) set.add(num);
        return set;
    }

    // Intersection of two arrays
    public static Set<Integer> intersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : arr1) set1.add(num);
        for (int num : arr2) if (set1.contains(num)) set2.add(num);
        return set2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(arr, 2);
        System.out.print("Left Rotated by 2: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        rightRotate(arr2, 2);
        System.out.print("Right Rotated by 2: ");
        for (int num : arr2) System.out.print(num + " ");
        System.out.println();

        int[] arr3 = {0, 1, 0, 3, 12};
        moveZeroes(arr3);
        System.out.print("Move Zeroes: ");
        for (int num : arr3) System.out.print(num + " ");
        System.out.println();

        int[] a = {1, 2, 4, 5};
        int[] b = {2, 3, 5, 7};
        System.out.println("Union: " + union(a, b));
        System.out.println("Intersection: " + intersection(a, b));
    }
}

