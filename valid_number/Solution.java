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

        if (endp == -1)
            return false;
        if (trimstr.length() == endp) {
            if (Character.isDigit(trimstr.charAt(endp - 1)) || (trimstr.charAt(endp - 1) == '.' && (endp - 1) != 0)) // for case like 1. is right and . is wrong
                return true;
            else
                return false;
        }
        else {
            if (endp == 0)
                return false; // for cases starting with e, like e10
            if (!isNumber(trimstr.substring(0, endp)))
                return false;

            char lastchar = trimstr.charAt(endp);
            if (lastchar == 'e') {
                return validint(trimstr.substring(endp + 1));
            }
            else
                return false;
        }

    }

    private int validfloat(String trimstr, boolean previousdot) {
        int endp = 0;
        while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;
        if (endp == trimstr.length() || trimstr.charAt(endp) == 'e')
            return endp;
        else if (trimstr.charAt(endp) == '.' && !previousdot) {
            int re = validfloat(trimstr.substring(endp + 1), true);
            return re != -1 ? 1 + endp + re : -1;
        }
        else
            return -1;
    }

    private boolean validint(String trimstr) {
        if (trimstr.length() <= 0)
            return false;
        if (trimstr.charAt(0) == '+' || trimstr.charAt(0) == '-')
            trimstr = trimstr.substring(1);
        if (trimstr.length() <= 0)
            return false;
        int endp = 0;
        while (endp < trimstr.length() && Character.isDigit(trimstr.charAt(endp))) endp++;
        return trimstr.length() == endp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.isNumber("2e0");

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

        System.out.println("Non-numerical Numbers");
        testSet.clear();
        testSet.add("abc");
        testSet.add("1a");
        testSet.add("a1");
        testSet.add("1e");
        testSet.add(" 1.3");
        for (String item : testSet)
            System.out.printf("%s %b\n", item, sol.isNumber(item));

        System.out.println("Exponential Numbers");
        testSet.clear();
        testSet.add("123e1");
        testSet.add("123e");
        testSet.add("e1");
        testSet.add("1e");
        testSet.add("122.e1");
        testSet.add("1.0e1");
        testSet.add(".e1");
        testSet.add("2e0");
        testSet.add("005047e+6");
        testSet.add("005047e+");




        for (String item : testSet)
            System.out.printf("%s %b\n", item, sol.isNumber(item));

    }
}
