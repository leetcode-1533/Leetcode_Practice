//http://www.cnblogs.com/yrbbest/p/5005947.html
package search_a_2d_matrix_ii;

public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int i = 0;
        int j = n;
        while (j >= 0 && i <= m) {
            if (target > matrix[i][j])
                i++;
            else if (target < matrix[i][j])
                j--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        boolean re = Solution.searchMatrix(test, 11);
        System.out.println(re);

//            System.out.println(re);
//            System.out.println("Test");
    }
}
