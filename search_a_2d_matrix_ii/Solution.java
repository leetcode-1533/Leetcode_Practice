public class Solution {
    public static int binarySearch_bydiagonal(int[][] matrix, int row_start, int target, int start, int end) {
        /*
        Binary search a 2d array by diagonal
        return index
        if not found, return smaller nearest value
         */
        int med = start;
        while((end - start) > 1 && target != matrix[med][med]) {
            med = (start +  end) / 2; // should be an int
            if (target > matrix[med][med])
                start = med;
            else
                end = med;
        }
        if (matrix[med][med] == target)
            return med;
        else if (matrix[end][med] <= target) // maximum value out of bound
            return end;
        else
            return start;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
            return true;
    }

    public static void main(String[] args) {
            int[][] test = new int[][]{{1, 3, 5, 7}, {10, 11, 16 ,20}, {23, 30, 34, 60}, {89, 90, 100, 101}};
            int re = Solution.binarySearch_bydiagonal(test, 0, 10, 0, 3);
            System.out.println(re);
//            System.out.println("Test");
    }
}
