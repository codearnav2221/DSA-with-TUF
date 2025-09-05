public class BinarySearchBasics {

    // 1. Basic Binary Search (Iterative)
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // 2. Binary Search (Recursive)
    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearchRecursive(arr, mid + 1, high, target);
        else return binarySearchRecursive(arr, low, mid - 1, target);
    }

    // 3. First Occurrence
    public static int firstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1; // keep searching left
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return ans;
    }

    // 4. Last Occurrence
    public static int lastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1; // keep searching right
            } else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return ans;
    }

    // 5. Count Occurrences
    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }

    // 6. Floor and Ceil
    public static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }

    public static int ceil(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 5, 7, 9, 11};

        System.out.println("Binary Search (Iterative) for 7: " + binarySearchIterative(arr, 7));
        System.out.println("Binary Search (Recursive) for 7: " + binarySearchRecursive(arr, 0, arr.length - 1, 7));

        System.out.println("First Occurrence of 4: " + firstOccurrence(arr, 4));
        System.out.println("Last Occurrence of 4: " + lastOccurrence(arr, 4));
        System.out.println("Count of 4: " + countOccurrences(arr, 4));

        System.out.println("Floor of 6: " + floor(arr, 6));
        System.out.println("Ceil of 6: " + ceil(arr, 6));
    }
}

