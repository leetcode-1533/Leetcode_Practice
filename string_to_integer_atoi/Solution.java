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
import java.math.BigInteger;

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


        BigInteger re = BigInteger.valueOf(0);
        BigInteger power = BigInteger.valueOf(10);

        for (int i = 0; i < endp; i++) {
            int val = Character.getNumericValue(trimstr.charAt(i));

            re = re.add(power.pow(endp - 1 - i).multiply(BigInteger.valueOf(val)));

            if (re.bitLength() > 32) {// 2147483647
                if (isNegative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }

        }
        return isNegative ? -re.intValue() : re.intValue();
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

        test1 = "2147483648";
        System.out.println(sol.myAtoi(test1));



    }
}
