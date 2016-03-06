package spiral_matrix;

import java.util.*;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return null;
        int top = 0;
        int left = 0;
        int bottom = matrix[0].length - 1;
        int right = matrix.length - 1;
        
        int n = matrix[0].length;
        int m = matrix.length;
        int size = m * n;
        
        ArrayList<Integer> acu = new ArrayList<Integer>();
        while(size != 0) {
            jtraverse(matrix, top, left, acu, n, true);
            itraverse(matrix, top + 1, right, acu, m - 1, true);
            jtraverse(matrix, bottom, right - 1, acu, n - 1, false);
            itraverse(matrix, bottom - 1, left, acu, m - 2, false);
            
            size = size + 4 - 2 * m - 2 * n;
            top += 1;
            bottom -= 1;
            left += 1;
            right -= 1;
            n -= 2;
            m -= 2;     
        }
        return acu;
        
    }
    
    private void itraverse(int[][] matrix, int istart, int j, ArrayList<Integer> acu, int leng, boolean norder) {
        if(norder) {
            while(leng-- != 0) {
                acu.add(matrix[istart++][j]);
            } 
        } else {
            while(leng-- != 0) {
                acu.add(matrix[istart--][j]);
            }          
        }
    }
    
    private void jtraverse(int[][] matrix, int i, int jstart, ArrayList<Integer> acu, int leng, boolean norder) {
        if(norder) {
            while(leng-- != 0) {
                acu.add(matrix[i][jstart++]);
            } 
        } else {
            while(leng-- != 0) {
                acu.add(matrix[i][jstart--]);
            }          
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> test = sol.spiralOrder(new int[][] {{1, 2}, {2, 4}});
        StdOut.println(test);
    }

}
