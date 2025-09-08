public class SearchOnAnswers {

    // 1. Allocate Minimum Number of Pages
    public static boolean isPossiblePages(int[] books, int students, int mid) {
        int count = 1, sum = 0;
        for (int pages : books) {
            if (pages > mid) return false;
            if (sum + pages > mid) {
                count++;
                sum = pages;
                if (count > students) return false;
            } else {
                sum += pages;
            }
        }
        return true;
    }

    public static int allocatePages(int[] books, int students) {
        int low = 0, high = 0, res = -1;
        for (int pages : books) high += pages;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossiblePages(books, students, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    // 2. Aggressive Cows
    public static boolean isPossibleCows(int[] stalls, int cows, int dist) {
        int count = 1, lastPlaced = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= dist) {
                count++;
                lastPlaced = stalls[i];
                if (count >= cows) return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        java.util.Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0], res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleCows(stalls, cows, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    // 3. Koko Eating Bananas
    public static boolean canEat(int[] piles, int h, int mid) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / mid);
        }
        return hours <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = java.util.Arrays.stream(piles).max().getAsInt(), res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, h, mid)) {
                res = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        // Allocate Pages
        int[] books = {12, 34, 67, 90};
        System.out.println("Min pages allocation (students=2): " + allocatePages(books, 2));

        // Aggressive Cows
        int[] stalls = {1, 2, 8, 4, 9};
        System.out.println("Aggressive cows (3 cows): " + aggressiveCows(stalls, 3));

        // Koko Eating Bananas
        int[] piles = {3, 6, 7, 11};
        System.out.println("Min eating speed (h=8): " + minEatingSpeed(piles, 8));
    }
}

