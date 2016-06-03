package valid_number;

/**
 * Created by y1275963 on 6/2/16.
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null)
            throw new IllegalArgumentException("Null String");

        String trimstr = s.trim();

        if (trimstr.length() == 0)
            return false;

        if (trimstr.charAt(0) == '-' || trimstr.charAt(0) == '+')
            trimstr = trimstr.substring(1);
        else if (!Character.isDigit(trimstr.charAt(0)) && trimstr.charAt(0) != '.')
            return false;

        if (trimstr.length() == 0)
            return false;

        boolean dot = false;
        if (trimstr.charAt(0) == '.') {
            trimstr = trimstr.substring(1);
            dot = true;
        }

        if (trimstr.length() == 0)
            return false;


        int endp = 0;
        while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;

        if (endp == trimstr.length())
            return true;
        else if (trimstr.charAt(endp) == 'e' || trimstr.charAt(endp) == '.') {
            if (dot) {
                if (trimstr.charAt(endp) == 'e')
                    return isNumber(trimstr.substring(endp + 1));
                else
                    return false;
            }

            endp++;
            if (trimstr.charAt(endp - 1) == 'e' && endp == trimstr.length())
                return false;

            while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;
            return endp == trimstr.length();
        }
        else
            return false;

    }

    private int validfloat(String trimstr, boolean previousdot) {
        int endp = 0;
        while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;
        if (endp == trimstr.length() || trimstr.charAt(endp) == 'e')
            return endp;
        else if (trimstr.charAt(endp) == '.' && !previousdot)
            return validfloat(trimstr.substring(endp), true);
        else
            return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String test;
        test = ".";
        System.out.println(test);
        System.out.println(sol.isNumber(test));

//        test = " 0.1 ";
//        System.out.println(test);
//        System.out.println(sol.isNumber(test));
//
//        test = "abc";
//        System.out.println(test);
//        System.out.println(sol.isNumber(test));
//
//        test = "1 a";
//        System.out.println(test);
//        System.out.println(sol.isNumber(test));
//
//        test = "2e10";
//        System.out.println(test);
//        System.out.println(sol.isNumber(test));

    }
}
