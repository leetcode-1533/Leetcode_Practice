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

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < N; j++) {
                if (ori[j] == null) {
                    int numofnull = 0;
                    while (j < N && ori[j] == null) {
                        numofnull++;
                        j++;
                    }
                    j--;
                    result.append(numofnull);
                }
                else
                    result.append(ori[j].charValue());
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
