package valid_anagram;

/**
 * Created by y1275963 on 12/20/16.
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 */
public class Solution {
    private static boolean contains(String s, String t) {
        boolean[] alphabet = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < t.length(); i++) {
            if (!alphabet[t.charAt(i) - 'a'])
                return false;
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        return Solution.contains(s, t) && Solution.contains(t, s);
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(Solution.isAnagram(s, t));
    }
}