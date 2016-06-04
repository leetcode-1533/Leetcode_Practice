package longest_substring_without_repeating_characters;

/**
 * Created by y1275963 on 6/4/16.
 */
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hist = new HashMap<>();
        int starti = 0;
        int best = 0;
        for (int j = 0; j < s.length(); j++) {
            if (hist.containsKey(s.charAt(j))) {
                int previous_loc = hist.get(s.charAt(j));
                starti = Math.max(previous_loc + 1, starti);
            }
            hist.put(s.charAt(j), j);
            best = Math.max(best, j - starti + 1);
        }

        return best;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.lengthOfLongestSubstring("abcabcbb");

        List<String> testSet = new ArrayList<String>();
        testSet.add("c");
        testSet.add("dvdf");
        testSet.add("abba");
        testSet.add("bbbbb");
        testSet.add("pwwkew");
        testSet.add("abcabcbb");

        for (String item : testSet)
            System.out.printf("%s of length %d\n", item ,sol.lengthOfLongestSubstring(item));
    }
}
