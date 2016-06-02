package reverse_words_in_a_string_ii;

/**
 * Created by y1275963 on 6/2/16.
 */
public class Solution {
    public void reverseWords(char[] s) {
        reverse(0, s.length - 1, s);
        int start = 0;
        int end = start;
        while(end < s.length) {
            while (s[end] != ' ') {
                end++;
                if (end == s.length)
                    break;
            }

            reverse(start, end - 1, s);
            start = end + 1;
            end = start;
        }

    }

    private void reverse(int start, int end, char[] s) {
        int i = start;
        int j = end;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String str = " a ";
        char[] strarray = str.toCharArray();

        Solution sol = new Solution();
        sol.reverseWords(strarray);

        System.out.print('@');
        for (char item : strarray)
            System.out.print(item);
        System.out.print('@');
    }
}
