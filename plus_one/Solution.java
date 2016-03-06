package plus_one;

import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null)
            return null;
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int carry = 0;
        int sum = digits[0] + 1;
        
        for(int i = 0; i < digits.length; i++) {
            if(i == 0)
                sum = digits[0] + 1;
            else 
                sum = digits[i] + carry;
            
            if(sum >= 10) {
                sum /= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.add(i, sum);            
        }
        if(carry == 1)
            ans.add(digits.length, 1);
        
        int[] ret = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ans = sol.plusOne(new int[] {3, 5, 6 ,7});
        StdOut.println(Arrays.toString(ans));
    }
    

}
