package valid_number;

/**
 * Created by y1275963 on 6/2/16.
 */
import java.util.ArrayList;

public class Solution {
    public boolean isNumber(String s) {
        if (s == null)
            throw new IllegalArgumentException("Null String");

        String trimstr = s.trim();

        if (trimstr.length() == 0)
            return false;

        if (trimstr.charAt(0) == '-' || trimstr.charAt(0) == '+')
            trimstr = trimstr.substring(1);

        int endp = validfloat(trimstr, false);

        if (trimstr.length() == endp && Character.isDigit(trimstr.charAt(endp - 1)))
            return true;
        else
            return false;
    }

    private int validfloat(String trimstr, boolean previousdot) {
        int endp = 0;
        while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;
        if (endp == trimstr.length() || trimstr.charAt(endp) == 'e')
            return endp;
        else if (trimstr.charAt(endp) == '.' && !previousdot)
            return 1+ endp + validfloat(trimstr.substring(endp + 1), true);
        else
            return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.isNumber(".");

        ArrayList<String> testSet = new ArrayList<>();
        testSet.add("");
        testSet.add(" ");
        testSet.add(".");
        testSet.add("..");
        testSet.add(".01");
        testSet.add("1.");
        testSet.add("1.0");
        testSet.add("132.323");
        for (String item : testSet)
            System.out.printf("%s %b\n", item, sol.isNumber(item));

        System.out.println();
        testSet.clear();
        testSet.add("abc");
        testSet.add(" 1.3");
        for (String item : testSet)
            System.out.printf("%s %b\n", item, sol.isNumber(item));



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
