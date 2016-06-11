package one_edit_distance;

/**
 * Created by y1275963 on 6/11/16.
 */
public class Solution {
    private boolean differby1(String s1, String s2) {
        // Assuming dist(s1 - s2) == 1
        if (s1.length() == 0 || s2.length() == 0)
            return true;

        if (s1.charAt(0) != s2.charAt(0))
            return differby0(s1.substring(1), s1);
        else
            return differby0(s1.substring(0, s1.length() - 1), s2);
    }

    private boolean differby0(String s1, String s2) {
        boolean difference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (difference)
                    return false;
                else
                    difference = true;
            }
        }
        return true;
    }

    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || (s.length() == 0 && t.length() == 0))
            return false;

        int len_diff = Math.abs(s.length() - t.length());

        if (len_diff == 0)
            return differby0(s, t);
        else if (len_diff == 1) {
            if (s.length() > t.length())
                return differby1(s, t);
            else
                return differby1(t, s);
        } else
            return false;
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "ac";
        Solution sol = new Solution();
        sol.isOneEditDistance(s1, s2);
    }
}
