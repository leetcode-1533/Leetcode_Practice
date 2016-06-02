package reverse_words_in_a_string;

/**
 * Created by y1275963 on 5/28/16.
 */
public class Solution {

    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder re = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i].length() > 0) {
                re.append(parts[i]);
                re.append(' ');
            }
        }
        String ans = re.toString();
        return ans.length() == 0 ? ans : ans.substring(0, ans.length() - 1);
    }

    public static void main(String[] args) {
        String str1 = " 1";
        String str2 = "the sky is blue";
        Solution sol = new Solution();
        System.out.print(sol.reverseWords(str1));
        System.out.print('@');

    }
}
