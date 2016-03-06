package reverse_integer;

import edu.princeton.cs.algs4.StdOut;

/*
 * 
 * @author y1275963
 * 
 * 1. overflow
 * 2. negative number
 * 3. 
 *
 */
public class Solution {
    
    public int reverse(int x) {
        long ans = 0;
        while(x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) 
            ans = 0;
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        StdOut.println(sol.reverse(Integer.MAX_VALUE / 10));
        StdOut.println(10 * (Integer.MAX_VALUE / 10) + 2 +" tk " + Integer.MIN_VALUE);        
    }

}
