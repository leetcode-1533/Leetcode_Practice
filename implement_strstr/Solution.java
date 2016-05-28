package implement_strstr;

/**
 * Created by y1275963 on 5/28/16.
 * Brute-Force Version
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int i = 0;
        while (i + needle.length() <= haystack.length()) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
            if (j == needle.length())
                return i;
            else
                i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Normal
        System.out.println("Normal");
        System.out.println(sol.strStr("HELLO WORLD", " WO"));
        // empty
        System.out.println("Empty");
        System.out.println(sol.strStr("HELLO WORLD", ""));
        System.out.println(sol.strStr("", "AB"));
        // At the end
        System.out.println("At the end");
        System.out.println(sol.strStr("aaaba", "ba"));


    }
}
