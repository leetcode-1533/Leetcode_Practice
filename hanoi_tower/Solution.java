package hanoi_tower;

/**
 * Created by y1275963 on 5/28/16.
 * My own recursion practice
 */

public class Solution {
    public static int printprecedure(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        return precedure(n, 'A', 'B', 'C');
    }

    private static int precedure(int n, char beg, char aux, char end) {
        int count = 0;
        if (n > 1) {
            count += precedure(n - 1, beg, end, aux);
            //precedure(1, beg, aux, end);
            count++;
            count += precedure(n - 1, aux, beg, end);
        } else { // n == 1
            return 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Solution.printprecedure(3));
    }
}
