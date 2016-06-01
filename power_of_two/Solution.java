package power_of_two;

/**
 * Created by y1275963 on 6/1/16.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        boolean hasOne = false;
        for (int k = 31; k >= 0; k--) {
            boolean kbit = ((n >> k) & 1) != 0;
            if (kbit && hasOne)
                return false;
            else if (kbit)
                hasOne = true;
        }
        return hasOne;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfTwo(-2147483648));

        int test = -2147483648;
        for (int k = 31; k >= 0; k--) {
            System.out.print((test >> k) & 1);
        }
        System.out.println();

        int test1 = -test;
        for (int k = 31; k >= 0; k--) {
            System.out.print((test1 >> k) & 1);
        }

    }
}
