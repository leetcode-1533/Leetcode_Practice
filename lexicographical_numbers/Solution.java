package lexicographical_numbers;

/**
 * Created by y1275963 on 12/9/16.
 */
import java.util.List;
import java.util.ArrayList;


public class Solution {
    public static List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> container = new ArrayList<>(n);
        for (int i = 1; i <= 9 && i <= n; i++)
            dfs(container, i, n);
        return container;
    }

    private static void dfs(List<Integer> container, int cur, int n) {
        container.add(cur);
        for (int i = cur * 10; (i <= cur * 10 + 9) && (i <= n); i++) {
            dfs(container, i, n);
        }
    }

    public static void main(String[] args) {
        List<Integer> re = Solution.lexicalOrder(100);
        for (int item : re) {
            System.out.println(item);
        }
//        int n = 123;
//        String[] temp = new String[n];
//        for (int i = 0; i < n; i++) {
//            temp[i] = Integer.toString(i);
//        }
//        Arrays.sort(temp);
//        for (String item : temp) {
//            System.out.println(item);
//        }
    }
}
