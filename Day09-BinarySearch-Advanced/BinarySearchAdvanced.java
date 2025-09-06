public class BinarySearchAdvanced {

    // 1. Search in Rotated Sorted Array
    public static int searchRotated(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return mid;

            // Left sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
            // Right sorted
            else {
                if (target > arr[mid] && target <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    // 2. Find Minimum in Rotated Sorted Array
    public static int findMinRotated(int[] arr) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    // 3. Single Element in Sorted Array
    public static int singleNonDuplicate(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) ||
                (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }

    // 4. Find Peak Element
    public static int findPeak(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low; // index of peak
    }

    // 5. Square Root using Binary Search
    public static int sqrtFloor(int n) {
        int low = 1, high = n, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= n / mid) { // avoid overflow
                ans = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] rotated = {4,5,6,7,0,1,2};
        System.out.println("Search in Rotated (target=0): " + searchRotated(rotated, 0));

        System.out.println("Min in Rotated: " + findMinRotated(rotated));

        int[] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println("Single element: " + singleNonDuplicate(arr));

        int[] peakArr = {1,2,1,3,5,6,4};
        System.out.println("Peak Element Index: " + findPeak(peakArr));

        int num = 40;
        System.out.println("Square Root Floor of " + num + ": " + sqrtFloor(num));
    }
}

