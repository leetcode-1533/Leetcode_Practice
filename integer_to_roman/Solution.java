package integer_to_roman;

/**
 * Created by y1275963 on 7/6/16.
 */
public class Solution {
    private static final int[] base = {
            1000, 900, 500, 400, 100,
            90, 50, 40, 10,
            9, 5, 4, 1
    };

    private static final String[] base_str = {
            "M", "CM", "D", "CD", "C",
            "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"
    };

    public String intToRoman(int num) {
        int[] pow = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            pow[i] = num / base[i];
            num -= pow[i] * base[i];
        }

        StringBuilder re = new StringBuilder();

        for (int i = 0; i < base.length; i++) {
            for (int time = 0; time < pow[i]; time++)
                re.append(base_str[i]);
        }
        return re.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.intToRoman(3945));
    }
}
