public class ArrayBasics {

    // Find maximum element
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // Find minimum element
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    // Reverse array
    public static void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Linear search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};

        System.out.println("Max: " + findMax(arr));
        System.out.println("Min: " + findMin(arr));

        reverseArray(arr);
        System.out.print("Reversed: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        int key = 8;
        int index = linearSearch(arr, key);
        System.out.println("Linear Search for " + key + ": " + (index == -1 ? "Not Found" : "Found at index " + index));

        int[] sortedArr = {1, 2, 3, 4, 5};
        System.out.println("Is sorted? " + isSorted(sortedArr));
    }
}
