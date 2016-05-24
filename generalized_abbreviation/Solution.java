package generalized_abbreviation;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
/**
 * Created by y1275963 on 5/24/16.
 */
public class Solution {

    public List<String> generateAbbreviations(String word) {
        int N = word.length();
        List<String> ans = new ArrayList<>((int) Math.pow(2, N));

        for (int i = 0; i < Math.pow(2, N); i++) {
            boolean[] mode = Solution.toBinary(i, N);
            Character[] ori = new Character[N];
            for (int j = 0; j < N; j++) { // string into character array
                if (mode[j])
                    ori[j] = new Character(word.charAt(j));
                else
                    ori[j] = null;
            }
        }
        return ans;
    }


    private static boolean[] toBinary(int number, int base) {
        final boolean[] ret = new boolean[base];
        for (int i = 0; i < base; i++) {
            ret[base - 1 - i] = (1 << i & number) != 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.generateAbbreviations("WORD");
//        boolean[] test = Solution.toBinary(10, 4);
//        for (boolean item : test) {
//            System.out.print(item);
//            System.out.print('\t');
//        }
    }
}
