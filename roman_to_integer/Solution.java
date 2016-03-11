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
    
    
    protected int[] romanToArray(String s) {
        int[] array = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            array[i] = map.get(s.charAt(i));
        }
        return array;
    }
    public int romanToInt(String s) {
//        return romanToArray(s);
        
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] test = sol.romanToArray("MXCVI");
        
       for(int item : test) {
           StdOut.printf("\t %d",item);
       }
    }

}
