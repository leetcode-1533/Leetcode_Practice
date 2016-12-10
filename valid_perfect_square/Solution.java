package valid_perfect_square;

/**
 * Created by y1275963 on 12/10/16.
 */
public class Solution {
    public static boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
//        System.out.println(binarySearch(1, num / 2, num));
        return binarySearch(1, num / 2 + 1, num) != -1;
    }

    private static long binarySearch(long st, long end, int target) {
        if (end - st > 1) {
            long mid = (st + end) / 2;
            if (mid * mid == target)
                return mid;
            else if (mid * mid > target)
                return binarySearch(st, mid, target);
            else
                return binarySearch(mid, end, target);
        }
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPerfectSquare(808201));
    }
}
