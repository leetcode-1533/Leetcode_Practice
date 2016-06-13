package read_n_characters_given_read4;

import utility.Reader4;
/* The read4API is defined in the parent class Reader4.
      int read4(char[] buf); */

/**
 * Created by y1275963 on 6/13/16.
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int realn = 0;

        while (realn < n) {
            char[] buf4 = new char[4];
            int readc = read4(buf4);
            int temp = Math.min(readc, n - realn);

            System.arraycopy(buf4 /* src */, 0 /* srcPos */,
                    buf /* dest */, realn /* destPos */, temp/* length */);
            realn += temp;

            if (readc < 4)
                break;
        }
        return realn;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "ab";
        sol.setContents(input.toCharArray());
        int n = 1;
        char[] output = new char[n];
        System.out.println("Read N: " + sol.read(output, n));
        for (char item : output)
            System.out.print(item);
    }
}