package spiral_matrix;

import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null)
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
            jtraverse(matrix, top, left, acu, )
        }
        
    }
    
    private void itraverse(int[][] matrix, int istart, int j, ArrayList<Integer> acu, int leng) {
        while(leng-- != 0) {
            acu.add(matrix[istart++][j]);
        }       
    }
    
    private void jtraverse(int[][] matrix, int i, int jstart, ArrayList<Integer> acu, int leng) {
        while(leng-- != 0) {
            acu.add(matrix[i][jstart++]);            
        }      
    }

}
