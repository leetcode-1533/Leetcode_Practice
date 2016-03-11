package n_queens;

import java.util.*;

/*
 * N Queen I and N Queen II shared the same answer, please track the commit history for N Queen II
 */
public class Solution {
    private class Board {
        boolean[][] board;
        int size;
        
        Board(int n) {
            size = n;
            board = new boolean[n][n];
        }
        
        ArrayList<String> board2str() {
            ArrayList<String> re = new ArrayList<String>(board.length);
            
            for(int i = 0; i < board.length; i++) {
                StringBuilder temp = new StringBuilder();
                for(int j = 0; j < board.length; j++) {
                    if(board[i][j])
                        temp.append('Q');
                    else
                        temp.append('.');                     
                }
                re.add(temp.toString());              
            }
            
            return re;
        }
        
        ArrayList<Board> perm(int level) {
            ArrayList<Board> sol = new ArrayList<Board>();
            for(int i = 0; i < size; i++) {    
                this.board[level][i] = true;
                if(this.isValid()) {
                  Board temp = new Board(size);
                  for(int iter = 0; iter < board.length; iter++)
                      temp.board[iter] = board[iter].clone();
                  sol.add(temp);
                }
                this.board[level][i] = false;
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
//                System.out.printf("sum: %d\n", sum);
                boolean flip = false;
                for(int i = 0; i <= sum; i++) {
                    int j = sum - i;
//                    System.out.printf("i: %d, j: %d\n", i, j);
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
//                System.out.printf("sum: %d\n", sum);
                
                for(int i = MINI; i < size; i++) {
                    int j = sum - i;
//                    System.out.printf("i: %d, j: %d\n", i, j);
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
//                System.out.printf("Diff: %d\n", diff);
                boolean flip1 = false;
                boolean flip2 = false;
                for(int i = 0; i < (size - diff); i++) {
                    int j = i + diff;
//                    System.out.printf("i: %d, j: %d\n", i, j);
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
    
    private void solveNqueens(int level, int n, Board gene, ArrayList<List<String>> container) {
        if(n == level)
            container.add(gene.board2str());
        else {
            for(Board item : gene.perm(level))
                solveNqueens(level + 1, n, item, container);           
        }        
    }
    
//    public int totalNQueens(int n) {
//        ArrayList<Board> re = new ArrayList<Board>();
//        Board board = new Board(n);
//        solveNqueens(0, n, board, re);
//        return re.size();
//    }
    
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> re = new ArrayList<List<String>>();
        Board board = new Board(n);
        solveNqueens(0, n, board, re);
        return re;       
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(9).size());
    }

}
