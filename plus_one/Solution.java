package plus_one;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null)
            return null;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int carry = 1;
        int sum = 0;
        
        for(int i = 0; i < digits.length; i++) {

            sum = digits[digits.length - 1 - i] + carry;
            
            if(sum >= 10) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.add(sum);            
        }
        
        if(carry == 1)
            ans.add(1);
        
        int[] ret = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            ret[ans.size() - 1 - i] = ans.get(i);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = sol.plusOne(new int[] {9, 9});
        StdOut.println(Arrays.toString(ans));
    }
    

}
