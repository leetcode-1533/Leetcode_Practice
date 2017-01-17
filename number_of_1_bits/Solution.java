package number_of_1_bits;

/**
 * Created by y1275963 on 1/17/17.
 */
public class Solution {
    public static int hammingWeight(int n) {
        int mask = 0x0001;
        int re = 0;
        while (mask != 0x0000) {
            if((n & mask) != 0)
                re++;

            mask = mask << 1;
        }
        return re;
    }

    public static void main(String[] args) {
        int re = Solution.hammingWeight(11);
        System.out.println(re);
    }
}
