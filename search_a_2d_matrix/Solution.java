package search_a_2d_matrix;

/**
 * Created by y1275963 on 12/5/16.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return true;
    }

    public int binarySearch(int[] test, int target, int start, int end) {
        /*
        Binary search a 1d array
        if not found, return smaller nearest value
         */
        int med = start;
        while((end - start) > 1 && target != test[med]) {
            med = (start +  end) / 2; // should be an int
            if (target > test[med])
                start = med;
            else
                end = med;
        }
        if (test[med] == target)
            return test[med];
        else if (test[end] < target) // out of bound
            return test[end];
        else
            return test[start];
    }

    public int binarySearch_byrows(int[][] matrix, int col, int target) {
        // return the floor
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.searchMatrix(null, 1));

        int[] test = new int[]{1, 2, 32, 50, 80};
        for (int item : test) {
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();

        int ans = sol.binarySearch(test, -5, 0, test.length-1);
        System.out.println("-5: " + ans);
        ans = sol.binarySearch(test, 1, 0, test.length-1);
        System.out.println("1: " + ans);
        ans = sol.binarySearch(test, 20, 0, test.length-1);
        System.out.println("20: " + ans);
        ans = sol.binarySearch(test, 90, 0, test.length-1);
        System.out.println("90: " + ans);

    }
}