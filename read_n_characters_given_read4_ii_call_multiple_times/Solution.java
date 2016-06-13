package read_n_characters_given_read4_ii_call_multiple_times;

/**
 * Created by y1275963 on 6/13/16.
 */
import utility.Reader4;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        Character c = read1();
        int realn = 0;
        while (c != null && n != 0) {
            buf[realn] = c;
            realn++;
            n--;
            c = read1();
        }
        return realn;
    }

    private char[] read4buff = new char[4];
    private int buffermax = 0;
    private int p = 4; // initial refresh
    private int curr_loc = 0;

    private void refresh() {
        if (p == 4) {
            buffermax = read4(read4buff);
            p = 0;
        }
    }

    private Character read1() {
        // null :failed
        refresh();
        if (p == buffermax)
            return null;
        else {
            p = p + 1;
            return read4buff[p - 1];
        }
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