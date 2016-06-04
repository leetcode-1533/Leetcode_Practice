package longest_substring_without_repeating_characters;

/**
 * Created by y1275963 on 6/4/16.
 */
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> counter = new HashSet<>();
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (counter.contains(current)) {
                if (counter.size() > best)
                    best = counter.size();
                counter.clear();
            }

            counter.add(current);
        }
        return counter.size() > best ? counter.size() : best;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.lengthOfLongestSubstring("dvdf");

        List<String> testSet = new ArrayList<String>();
        testSet.add("c");
        testSet.add("abcabcbb");
        testSet.add("bbbbb");
        testSet.add("pwwkew");
        for (String item : testSet)
            System.out.printf("%s of length %d\n", item ,sol.lengthOfLongestSubstring(item));
    }
}
