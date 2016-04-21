package unique_paths_ii;

/**
 * Created by y1275963 on 4/21/16.
 */
public class Solution {

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
    private int cal(int i, int j, int[][] ans, int[][] ob) {
        if (i == 0 || j == 0)
            return 0;
        else {
            if(ob[i - 1][j - 1] == 1)
                return 0;
            else {
                if (i == 1 && j == 1)
                    return 1;
                else
                    return ans[i - 1][j] + ans[i][j - 1];
            }
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] ans = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                ans[i][j] = cal(i, j, ans, obstacleGrid);
            }
        }

        return ans[m][n];
    }

    public static void main(String[] args) {
        int[][] ob =
                {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        Solution sol = new Solution();
        System.out.println(sol.uniquePathsWithObstacles(ob));
    }
}
