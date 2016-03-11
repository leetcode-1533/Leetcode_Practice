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
            return (checkVert() && checkDiag1() && checkDiag2());          
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
            int sum = 0;
            for(sum = 0; sum < size; sum++) {
                System.out.printf("sum: %d\n", sum);
                boolean flip = false;
                for(int i = 0; i <= sum; i++) {
                    int j = sum - i;
                    System.out.printf("i: %d, j: %d\n", i, j);
                    if(board[i][j] == true) {
                        if(flip == false)
                            flip = true;
                        else 
                            return false;
                    }
                }              
            }           
            int MINI = 1;
            for(; sum <= (size - 1) * 2; sum++) {
                boolean flip = false;
                System.out.printf("sum: %d\n", sum);
                
                for(int i = MINI; i < size; i++) {
                    int j = sum - i;
                    System.out.printf("i: %d, j: %d\n", i, j);
                    if(board[i][j] == true) {
                        if(flip == false)
                            flip = true;
                        else
                            return false;
                    }                  
                }
                MINI++;
            }
            return true;
        }
        
        boolean checkDiag2() {
            for(int diff = 0; diff < size; diff++) {
                System.out.printf("Diff: %d\n", diff);
                boolean flip1 = false;
                boolean flip2 = false;
                for(int i = 0; i < (size - diff); i++) {
                    int j = i + diff;
                    System.out.printf("i: %d, j: %d\n", i, j);
                    if(board[i][j] == true) {
                        if(flip1 == true)
                            return false;
                        else
                            flip1 = true;
                    }
                    if(diff != 0 ) {
                        if(board[j][i] == true) {
                            if(flip2 == true)
                                return false;
                            else
                                flip2 = true;
                        }    
                    }               
                }             
            }
            return true;           
        }       
    }
    
    public void test() {
        Board test = new Board(4);
        test.checkDiag1();
//        test.checkDiag2();
    }
    
    public List<List<String>> solveNQueens(int n) {
        
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.test();
    }

}
