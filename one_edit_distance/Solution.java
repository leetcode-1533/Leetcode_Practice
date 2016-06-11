package one_edit_distance;


/**
 * Created by y1275963 on 6/11/16.
 */
public class Solution {
    private boolean differby1(String s1, String s2) {
        // Assuming dist(s1 - s2) == 1
        if (s1.length() == 0 || s2.length() == 0)
            return true;
        boolean diff = false;

        for (int i = 0; i < s1.length(); i++) {
            if ((diff && i >= s2.length() + 1) || (!diff && i >= s2.length()))
                return true;
            if (diff && s1.charAt(i) != s2.charAt(i - 1))
                return false;
            if (!diff && s1.charAt(i) != s2.charAt(i)) {
                diff = true;
            }
        }
        return true;
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
        return difference;
    }


    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null)
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
        String s1;
        String s2;
        Solution sol = new Solution();

        s1 = "a";
        s2 = "ba";
        System.out.println(s1 + "\n" + s2 + "\n" + sol.isOneEditDistance(s1, s2));

        s1 = "cab";
        s2 = "ad";
        System.out.println(s1 + "\n" + s2 + "\n" + sol.isOneEditDistance(s1, s2));

        s1 = "a";
        s2 = "ac";
        System.out.println(s1 + "\n" + s2 + "\n" + sol.isOneEditDistance(s1, s2));

    }
}

