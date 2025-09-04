
import java.util.*;

public class ArraysHard {

    // 1. Kadane's Algorithm
    public static int kadane(int[] arr) {
        int maxSoFar = arr[0], curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]);
            maxSoFar = Math.max(maxSoFar, curr);
        }
        return maxSoFar;
    }

    // 2. Kadane + print subarray
    public static void kadaneSubarray(int[] arr) {
        int maxSoFar = arr[0], curr = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > curr + arr[i]) {
                curr = arr[i];
                tempStart = i;
            } else {
                curr += arr[i];
            }

            if (curr > maxSoFar) {
                maxSoFar = curr;
                start = tempStart;
                end = i;
            }
        }

        System.out.print("Max Subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + (i < end ? ", " : ""));
        }
        System.out.println("] Sum = " + maxSoFar);
    }

    // 3. Two Sum Problem
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // 4. Three Sum Problem
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // skip duplicates
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }

    // 5. Maximum Product Subarray
    public static int maxProductSubarray(int[] arr) {
        int maxProd = arr[0], minProd = arr[0], ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Kadane's Max Sum: " + kadane(arr));
        kadaneSubarray(arr);

        int[] nums = {2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        System.out.println("Two Sum indices: " + Arrays.toString(res));

        int[] nums2 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Three Sum: " + threeSum(nums2));

        int[] prodArr = {2,3,-2,4};
        System.out.println("Max Product Subarray: " + maxProductSubarray(prodArr));
    }
}
