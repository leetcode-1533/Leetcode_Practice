package unique_paths;

/**
 * Created by y1275963 on 4/21/16.
 */

// S(i, j) = S(i - 1, j) + S(i, j - 1)

public class Solution {
    /*
    Bottom up method: V1
     */
//    public int uniquePaths(int m, int n) {
//        int[][] ans = new int[m + 1][n + 1]; // from 0 to m
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                ans[i][j] = cal(i, j, ans);
//            }
//        }
//        return ans[m][n];
//    }
//
//    private int cal(int i, int j, int[][] ans) {
//        if (i == 0 || j == 0)
//            return 0;
//        if (i == 1 && j == 1)
//            return 1;
//        else
//            return ans[i - 1][j] + ans[i][j - 1];
//    }
    /*
    Top down method V2: without memorization
     */
//    public int uniquePaths(int m, int n) {
//        if (m < 0 || n < 0) {
//            return 0;
//        }
//
//        if (m == 1 && n == 1) {
//            return 1;
//        }
//        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
//
//    }
    /*
    Top Down method: V3: Using memorization
     */
    public int calPaths(int i, int j, int mat[][]) {
        if (i == 0 || j == 0)
            return 0;
        if (mat[i][j] == -1) {
            mat[i][j] = calPaths(i - 1, j, mat) + calPaths(i, j - 1, mat);
        }
        return mat[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                ans[i][j] = -1; //Unreached
            }
        }
        ans[1][1] = 1;

        return calPaths(m, n, ans);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(4, 5));
    }
}
