package valid_anagram;

/**
 * Created by y1275963 on 12/20/16.
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 */
public class Solution {
    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int item : alphabet) {
            if (item != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "a";
        System.out.println(Solution.isAnagram(s, t));
    }
}