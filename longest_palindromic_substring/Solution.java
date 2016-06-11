package longest_palindromic_substring;

/**
 * Created by y1275963 on 6/11/16.
 */
public class Solution {
    private int[][] dist;

    private void construct_dist(String s1, String s2) {
        dist = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dist[i][j] = dist[i - 1][j - 1] + 1;
                else
                    dist[i][j] = 0;
            }
        }
    }

    public String longestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        construct_dist(s, rev_s);

        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                if (s.length() - j + dist[i][j] != i)
                    dist[i][j] = 0;
            }
        }

        int maxi = 0, max = 0;
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[0].length; j++) {
                if (dist[i][j] > max) {
                    maxi = i;
                    max = dist[i][j];
                }
            }
        }
        return s.substring(maxi - max, maxi);
    }

    public static void main(String[] args) {
        String s1 = "abacdfgdcaba";
        Solution sol = new Solution();

        System.out.println(sol.longestPalindrome(s1));
        System.out.println();
        for (int[] item : sol.dist) {
            for (int itemc : item) {
                System.out.print(itemc);
            }
            System.out.print('\n');
        }
    }
}
