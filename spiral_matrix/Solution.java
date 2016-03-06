package spiral_matrix;

import java.util.*;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> acu = new ArrayList<Integer>();

        if(matrix == null || matrix.length == 0)
            return acu;
        
        int n = matrix[0].length;
        int m = matrix.length;
        int size = m * n;
        
        int top = 0;
        int left = 0;
        int bottom = m - 1;
        int right = n - 1;
        

        
        while(true) {
            jtraverse(matrix, top, left, acu, n, true);
            size -= n;
            if(size <= 0)
                break;
            itraverse(matrix, top + 1, right, acu, m - 1, true);
            size -= m - 1;
            if(size <= 0)
                break;
            jtraverse(matrix, bottom, right - 1, acu, n - 1, false);
            size -= n - 1;
            if(size <= 0)
                break;
            itraverse(matrix, bottom - 1, left, acu, m - 2, false);
            size -= m - 2;
            if(size <= 0)
                break;
            
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
            while(leng-- > 0) {
                acu.add(matrix[istart++][j]);
            } 
        } else {
            while(leng-- > 0) {
                acu.add(matrix[istart--][j]);
            }          
        }
    }
    
    private void jtraverse(int[][] matrix, int i, int jstart, ArrayList<Integer> acu, int leng, boolean norder) {
        if(norder) {
            while(leng-- > 0) {
                acu.add(matrix[i][jstart++]);
            } 
        } else {
            while(leng-- > 0) {
                acu.add(matrix[i][jstart--]);
            }          
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] tk= {
                {1, 2, 3, 4},
                {5, 6, 7 ,8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> test = sol.spiralOrder(tk);
        StdOut.println(test);
    }

}
