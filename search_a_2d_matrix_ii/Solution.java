public class Solution {
    public static int binarySearch_bydiagonal(int[][] matrix, int target, int start, int end, int row_shift, int col_shift) {
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

    private static int binarySearch_bycolumns(int[][] matrix, int row, int target, int start, int end) {
        /*
        Binary search a 2d array by rows
        return value
        if not found, return smaller nearest value
         */
        int med = start;
        while ((end - start) > 1 && target != matrix[row][med]) {
            med = (start + end) / 2; // should be an int
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

    public static boolean searchMatrix(int[][] matrix, int target) {
        return true;
//            int m = matrix.length;
//            int n = matrix[0].length;
//            int min_mn = Math.min(m, n);
//            if (m < n) {
//            }
//            int dig_starter = Solution.binarySearch_bydiagonal(matrix, 0, target, 0, );
//            int col_ans = Solution.binarySearch_bycolumns(matrix, dig_starter, target,
//            int row_ans = Solution.binarySearch_byrows(matrix
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}};
        int re = Solution.binarySearch_bydiagonal(test, 122, 0, 2, 0, 2);
        System.out.println(re);

//            System.out.println(re);
//            System.out.println("Test");
    }
}
