package generalized_abbreviation;

/**
 * Created by y1275963 on 5/24/16.
 */
public class Solution {
    private static boolean[] toBinary(int number, int base) {
        final boolean[] ret = new boolean[base];
        for (int i = 0; i < base; i++) {
            ret[base - 1 - i] = (1 << i & number) != 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        boolean[] test = Solution.toBinary(10, 4);
        for (boolean item : test) {
            System.out.print(item);
            System.out.print('\t');
        }
    }

}
