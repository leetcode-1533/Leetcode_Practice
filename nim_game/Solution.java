package nim_game;

/**
 * Created by y1275963 on 6/28/16.
 */
public class Solution {
    public boolean canWinNim(int n) {
        if (n % 4 == 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[] testCase = new int[] {1, 2, 3, 4, 5, 6, 7};
        Solution sol = new Solution();
        for (int item : testCase) {
            System.out.println(item + " result is: " + sol.canWinNim(item));
        }
    }
}
