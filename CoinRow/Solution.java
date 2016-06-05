package CoinRow;

/**
 * Created by y1275963 on 6/5/16.
 * Self Practice
 * Coin-Row problem
 * Dynamic Programming
 */
public class Solution {
    public int coinrow(int[] coins) {
        if (coins == null || coins.length == 0)
            throw new IllegalArgumentException();
        int[] previousN = new int[coins.length + 1];
        previousN[0] = 0;
        previousN[1] = coins[0];
        for (int i = 2; i < previousN.length; i++) {
            previousN[i] = Math.max(coins[i - 1] + previousN[i - 2], previousN[i - 1]);
        }
        return previousN[previousN.length - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] coins = new int[] {2, 3};
        System.out.println(sol.coinrow(coins));
    }
}
