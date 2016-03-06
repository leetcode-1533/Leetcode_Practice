package palindrome_number;
// Determine whether an integer is a palindrome. Do this without extra space.
public class Solution {
    
    private long reverse(int x) {
        long ans = 0;
        while(x != 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
    
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        long rev = reverse(x);
        long longx = (long) x;
        return (longx == rev);   
    }

}
