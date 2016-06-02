package string_to_integer_atoi;

/**
 * Created by y1275963 on 6/2/16.
 *
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases.
 If you want a challenge,
 please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely(ie, no given input specs).
 You are responsible to gather all the input requirements up front.

 */

public class Solution {
    public int myAtoi(String str) {
        if (str == null)
            throw new IllegalArgumentException("Null String");

        String trimstr = str.trim();

        if (trimstr.length() == 0)
            return 0;


        boolean isNegative = false;
        if (trimstr.charAt(0) == '-') {
            trimstr = trimstr.substring(1);
            isNegative = true;
        } else if (trimstr.charAt(0) == '+')
            trimstr = trimstr.substring(1);

        int endp = 0;
        while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;


        long re = 0;

        for (int i = 0; i < endp; i++) {
            int val = Character.getNumericValue(trimstr.charAt(i));
            if (isNegative)
                val = -val;

            re += val * Math.pow(10, endp - 1 - i) ;

            if (re < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (re > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return (int) re;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toString(Integer.MAX_VALUE));
//        System.out.println(Integer.toString(Integer.MIN_VALUE));
//
//        System.out.println(BigInteger.valueOf(Integer.MAX_VALUE).bitCount());
//        System.out.println(BigInteger.valueOf(Integer.MAX_VALUE).bitLength());

        String test1;
        Solution sol = new Solution();
        test1 = Integer.toString(Integer.MIN_VALUE);
        System.out.println(sol.myAtoi(test1));
//
        test1 = Integer.toString(Integer.MAX_VALUE);
        System.out.println(sol.myAtoi(test1));

        test1 = "-2147483649";
        System.out.println(sol.myAtoi(test1));



    }
}
