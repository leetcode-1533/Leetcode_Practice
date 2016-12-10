package surrounded_regions;

/**
 * Created by y1275963 on 12/10/16.
 */
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        Queue<int[]> bfs = new ArrayDeque<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                bfs.add(new int[]{i, 0});
            if (board[i][n - 1] == 'O')
                bfs.add(new int[]{i, n - 1});
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                bfs.add(new int[]{0, i});
            if (board[m - 1][i] == 'O')
                bfs.add(new int[]{m - 1, i});
        }

        while (!bfs.isEmpty()) {
            int[] xy = bfs.poll();
            board[xy[0]][xy[1]] = 'Y';
            for (int[] n_xy : neighbor(xy, m, n)) {
                if (board[n_xy[0]][n_xy[1]] == 'O')
                    bfs.add(n_xy);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private static List<int[]> neighbor(int[] starter, int m, int n) {
        List<int[]> container = new ArrayList<>(2);

        int i = starter[0];
        int j = starter[1];

        if (i > 0)
            container.add(new int[] {i - 1, j});
        if (i < m - 1)
            container.add(new int[] {i + 1, j});
        if (j > 0)
            container.add(new int[] {i, j - 1});
        if (j < n - 1)
            container.add(new int[] {i, j + 1});

        return container;
    }


    public static void main(String[] args) {
//        char[][] board = new char[][]
//                {{'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}};
        char[][] board = new char[][]{};
        Solution.solve(board);

        for (char[] items : board) {
            for (char item : items) {
                System.out.print(item);
            }
            System.out.println();
        }
    }
}