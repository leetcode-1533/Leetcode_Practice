package search_a_2d_matrix;

/**
 * Created by y1275963 on 12/5/16.
 */
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row_index = Solution.binarySearch_byrows(matrix, 0, target, 0, matrix.length - 1);
        int re = Solution.binarySearch_bycolumns(matrix, row_index, target, 0, matrix[row_index].length - 1);
        return re == target;
    }

    private static int binarySearch_byrows(int[][] matrix, int col, int target, int start, int end) {
      /*
        Binary search a 2d array by rows
        return index
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
            return med;
        else if (matrix[end][col] <= target) // maximum value out of bound
            return end;
        else
            return start;
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


    public static void main(String[] args) {
        // 2d cases
        int[][] matrix_test = new int[][]{{1, 3, 5, 7}, {10, 11, 16 ,20}, {23, 30, 34, 60}};
        System.out.println(Solution.searchMatrix(matrix_test, 12));
        // 1d cases
        matrix_test = new int[][]{{1, 3}};
        System.out.println(Solution.searchMatrix(matrix_test, 5));

        matrix_test = new int[][]{{1}, {3}};
        System.out.println(Solution.searchMatrix(matrix_test, 1));

    }
}