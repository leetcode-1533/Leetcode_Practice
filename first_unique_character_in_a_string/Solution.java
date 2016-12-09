package first_unique_character_in_a_string;

/**
 * Created by y1275963 on 12/9/16.
 * Time complexity : o(2*n)
 * Space Complexity: o(n)
 */
import java.util.HashMap;

public class Solution {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> occurance = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            char cur_char = s.charAt(i);
            if (!occurance.containsKey(cur_char))
                    occurance.put(cur_char, 0);
            else {
                int temp = occurance.get(cur_char);
                occurance.put(cur_char, temp + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (occurance.get(s.charAt(i)) == 0)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Solution.firstUniqChar("loveleetcode"));
    }
}

