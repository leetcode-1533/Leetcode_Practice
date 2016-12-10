package lexicographical_numbers;

/**
 * Created by y1275963 on 12/9/16.
 */
import edu.princeton.cs.algs4.StdIn;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> re = new ArrayList<>(n);
        int group_length = cal_grouplength(n);

        int[] index_array = new int[group_length];
        int p = 0;
        for (int i = 1; i <= 9; i++) {
            int i_temp = i;
            while (i_temp <= n) {
                index_array[p] = i_temp;
                p++;
                i_temp = i_temp * 10;
            }
        }

        int[] acc_array = new int[group_length + 1];
        acc_array[0] = 0;
        acc_array[1] = 1;
        for (int i = 0; i < group_length; i++) {
            int max_range = (int) Math.pow(10, (int) Math.log10(index_array[i]));
            acc_array[i + 1] = acc_array[i] + (max_range > (n - index_array[i] + 1) ? (n - index_array[i] + 1) : max_range ) ;
        }
        for (int item : index_array)
            System.out.println(item);
        System.out.println();
//        for (int item : acc_array)
//            System.out.println(item);

        for (int i = 0; i < index_array.length; i++) {
            int starter = index_array[i];
            for (int j = acc_array[i]; j < acc_array[i + 1]; j++) {
                re.add(starter);
                starter = starter + 1;
            }
        }

//        System.out.println();
//        for (int item : re) {
//            System.out.println(item);
//        }

        return re;
    }

    private static int cal_grouplength(int n) {
        int tail = (int) Math.log10(n);
        int head = n / ((int) Math.pow(10, tail));
        return tail * 9 + head;
    }

    public static void main(String[] args) {
        int n = 123;
        String[] temp = new String[n];
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.toString(i);
        }
        Arrays.sort(temp);
        for (String item : temp) {
            System.out.println(item);
        }
//        Solution.lexicalOrder(105);
//        System.out.println(Solution.cal_grouplength(10));
//        System.out.println(Solution.cal_grouplength(10));
    }
}
