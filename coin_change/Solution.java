package coin_change;

/**
 * Created by y1275963 on 6/5/16.
 */
import java.util.PriorityQueue;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] previousN = new int[amount + 1];
        previousN[0] = 0;
        PriorityQueue<Integer> session = new PriorityQueue<>();

        for (int i = 1; i < previousN.length; i++) {
            session.clear();
            for (int coinval : coins) {
                if (i >= coinval && previousN[i - coinval] != -1)
                    session.add(previousN[i - coinval]);
            }
            if (session.isEmpty())
                previousN[i] = -1;
            else
                previousN[i] = session.peek() + 1;
        }
        return previousN[previousN.length - 1];
    }

    public static void main(String[] args) {
        int[] coins = new int[] {2};
        int amount = 4;
        Solution sol = new Solution();
        System.out.println(sol.coinChange(coins, amount));
    }
}
