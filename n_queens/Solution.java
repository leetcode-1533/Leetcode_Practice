package n_queens;

import java.util.*;

public class Solution {
    private class Board {
        boolean[][] board;
        int size;
        
        Board(int n) {
            size = n;
            board = new boolean[n][n];
        }
        
        Iterable<Board> perm(int level) {
            ArrayList<Board> sol = new ArrayList<Board>();
            for(int i = 0; i < size; i++) {
                Board temp = new Board(size);
                temp.board[level][i] = true;
                if(temp.isValid())
                    sol.add(temp);
            }
            return sol;
        }
        
        boolean isValid() {
            
        }
        
        boolean checkVert() {
            for(int j = 0; j < size; j++) {
                boolean flip = false;
                for(int i = 0; i < size; i++) {
                    if(board[i][j] == true) {
                        if(flip == false)
                            flip = true;
                        else
                            return false;
                    }                                  
                }
            }
            return true;          
        }
        
        boolean checkDiag1() {
            
        }
        
        boolean checkDiag2() {
            for(int diff = 1; diff < size; diff++) {
                boolean flip1 = false;
                boolean flip2 = false;
                for(int i = 0; i < (size - diff); i++) {
                    int j = i + diff;
                    if(board[i][j] == true) {
                        if(flip1 == true)
                            return false;
                        else
                            flip1 = true;
                    }
                    if(board[j][i] == true) {
                        if(flip2 == true)
                            return false;
                        else
                            flip2 = true;
                    }                   
                }             
            }
            return true;           
        }       
    }
    
    public void test() {
        Board test = new Board(5);
        System.out.println("test");
    }
    
    public List<List<String>> solveNQueens(int n) {
        
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.test();
    }

}
