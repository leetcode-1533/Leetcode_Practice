package roman_to_integer;

import edu.princeton.cs.algs4.StdOut;
import java.util.HashMap;

public class Solution {
    
    private HashMap<Character, Integer> map = 
            new HashMap<Character, Integer>() {{
        put('I', 1); put('V', 5); put('X', 10);
        put('L', 50); put('C', 100); put('D', 500);
        put('M', 1000);
    }};
    
    
    private int[] romanToArray(String s) {
        int[] array = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            array[i] = map.get(s.charAt(i));
        }
        return array;
    }
    public int romanToInt(String s) {
        int[] array = romanToArray(s);
        if(s == null) {
            return 0;
        }
        int sum = array[0];

        for(int i = 1; i < array.length; i++) {
            sum += array[i];
            if(array[i] > array[i - 1]) {
                sum -= 2 * array[i - 1];               
            }
        }
        return sum;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        StdOut.println(sol.romanToInt("MXCVI"));

    }

}
