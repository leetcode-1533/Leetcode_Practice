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

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < N; j++) {
                if (!mode[j]) {
                    int numofnull = 0;
                    while (j < N && !mode[j]) {
                        numofnull++;
                        j++;
                    }
                    j--; // over heading
                    result.append(numofnull);
                }
                else
                    result.append(word.charAt(j));
            }
            ans.add(result.toString());
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
        List<String> res = test.generateAbbreviations("word");
        for (String item : res)
            System.out.println(item);

//        boolean[] test = Solution.toBinary(10, 4);
//        for (boolean item : test) {
//            System.out.print(item);
//            System.out.print('\t');
//        }
    }
}
