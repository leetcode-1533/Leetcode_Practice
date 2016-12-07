//http://www.cnblogs.com/yrbbest/p/5005947.html
package search_a_2d_matrix_ii;

public class Solution {
    private static int binarySearch_bydiagonal(int[][] matrix, int target, int start, int end, int row_shift, int col_shift) {
        /*
        Binary search a 2d array by diagonal
        return index
        if not found, return smaller nearest value
         */
        int med = start;
        while ((end - start) > 1 && target != matrix[med + row_shift][med + col_shift]) {
            med = (start + end) / 2; // should be an int
            if (target > matrix[med + row_shift][med + col_shift])
                start = med;
            else
                end = med;
        }

        if (matrix[med + row_shift][med + col_shift] == target)
            return med;
        else if (matrix[end + row_shift][end + col_shift] <= target) // maximum value out of bound
            return end;
        else
            return start;
    }

    private static int binarySearch_byrows(int[][] matrix, int col, int target, int start, int end) {
      /*
        Binary search a 2d array by rows
        return value
        if not found, return smaller nearest value
         */
        int med = start;
        while((end - start) > 1 && target != matrix[med][col]) {
            med = (start +  end) / 2; // should be an int
            if (target > matrix[med][col])
                start = med;
            else
                end = med;
        }

        if (matrix[med][col] == target)
            return matrix[med][col];
        else if (matrix[end][col] <= target) // maximum value out of bound
            return matrix[end][col];
        else
            return matrix[start][col];
    }

    private static int binarySearch_bycolumns(int[][] matrix, int row, int target, int start, int end) {
      /*
        Binary search a 2d array by rows
        return value
        if not found, return smaller nearest value
         */
        int med = start;
        while((end - start) > 1 && target != matrix[row][med]) {
            med = (start +  end) / 2; // should be an int
            if (target > matrix[row][med])
                start = med;
            else
                end = med;
        }

        if (matrix[row][med] == target)
            return matrix[row][med];
        else if (matrix[row][end] <= target) // maximum value out of bound
            return matrix[row][end];
        else
            return matrix[row][start];
    }

    private static boolean crossSearch(int[][] matrix, int target, int diag_starter) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int col_ans = Solution.binarySearch_bycolumns(matrix, diag_starter, target, 0, n);
        int row_ans = Solution.binarySearch_byrows(matrix, diag_starter, target, 0, m);
        return (col_ans == target) || (row_ans == target);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int min_mn = Math.min(m, n);

        int dig_starter1 = Solution.binarySearch_bydiagonal(matrix, target, 0, min_mn, 0, 0);
        boolean dig1_ans = Solution.crossSearch(matrix, target, dig_starter1);

        int row_shift = 0;
        int col_shift = 0;
        if (m < n) {
            col_shift = (n - m);
        } else {
            row_shift = (m - n);
        }
        int dig_starter2 = Solution.binarySearch_bydiagonal(matrix, target, 0, min_mn, row_shift, col_shift);
        boolean dig2_ans = Solution.crossSearch(matrix, target, dig_starter2 + col_shift + row_shift);
        return dig1_ans || dig2_ans;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
        boolean re = Solution.searchMatrix(test, 11);
        System.out.println(re);

//            System.out.println(re);
//            System.out.println("Test");
    }
}
