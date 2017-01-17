package reverse_bits;

/**
 * Created by y1275963 on 1/17/17.
 */
public class Solution {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int re = 0x0000;
        int rail_mask = 0x0001;
        int front_mask = 0x80000000;
        for (int i = 0; i < 32; i++) {
            if ((n & rail_mask) != 0) {
                re = re ^ front_mask;
            }
            front_mask = front_mask >>> 1;
            rail_mask = rail_mask << 1;
        }
        return re;
    }

    private static void printBits(int n) {
        int mask = 0x80000000;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                System.out.printf("1");
            else
                System.out.printf("0");
            mask = mask >>> 1;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int temp = 2;
        System.out.println(Solution.reverseBits(temp));
//        Solution.printBits(2);
    }
}