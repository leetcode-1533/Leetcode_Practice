package valid_palindrome;

/**
 * Created by y1275963 on 5/28/16.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.equals(""))
            return true;

        int i = nextPos(-1, '>', s);
        int j = nextPos(s.length(), '<', s);

        while (j - i > 1) {
            if (!sameChar(i, j, s))
                return false;
            i = nextPos(i, '>', s);
            j = nextPos(j, '<', s);
        }
        if (i > j)
            return false; // in case of over run;

        return sameChar(i, j, s); // odd or even
    }

    private boolean sameChar(int i, int j, String s) {
        char a = s.charAt(i);
        char b = s.charAt(j);

        if (Character.isDigit(a))
            return a == b;
        else if (Character.isLetter(a))
            return (Character.toLowerCase(a) == Character.toLowerCase(b));
        else
            throw new IllegalArgumentException("Wrong Input");
    }

    private int nextPos(int i, char direction, String s) {
        switch (direction) {
            case '>': {
                i++;
                while (i <= s.length() - 1 && !Character.isLetterOrDigit(s.charAt(i)))
                    i++;
            } break;

            case '<': {
                i--;
                while (i >= 0 && !Character.isLetterOrDigit(s.charAt(i)))
                    i--;
            } break;

            default: {
                throw new IllegalArgumentException();
            }
        }
        return i;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("aA"));
//        System.out.println(Character.isLetterOrDigit(' '));
    }
}