package lexicographical_numbers;

/**
 * Created by y1275963 on 12/9/16.
 */
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> re = new ArrayList<>(n);
        int group_length = cal_grouplength(n);

        int[] index_array = new int[group_length];
        int p = 0;
        for (int i = 1; i <= 9; i++) {
            int i_temp = i;
            while (i_temp < n) {
                index_array[p] = i_temp;
                p++;
                i_temp = i_temp * 10;
            }
        }

        int[] acc_array = new int[group_length];
        acc_array[0] = index_array[0];
        for (int i = 1; i < group_length - 1; i++) {
            acc_array[i] = acc_array[i - 1] + index_array[i];
        }
        for (int item : index_array)
            System.out.println(item);
        System.out.println();
        for (int item : acc_array)
            System.out.println(item);

        return null;
    }

    private static int cal_grouplength(int n) {
        int tail = (int) Math.log10(n);
        int head = n / ((int) Math.pow(10, tail));
        return tail * 9 + head;
    }

    public static void main(String[] args) {
        Solution.lexicalOrder(13);
    }
}
