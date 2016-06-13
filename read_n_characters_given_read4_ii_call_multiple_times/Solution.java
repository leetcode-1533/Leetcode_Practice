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
        int offset = 0;
        while (hasNext() && n != 0) {
            char c = read1();
            buf[offset] = c;
            offset++;
            n--;
        }
//        curr_loc += offset;
        return offset;
    }

    private char[] read4buff = new char[4];
    private int buffermax = 0; //0 ~ 3 read4's return
    private int p = 4; // initial refresh
//    private int curr_loc = 0;

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

    private boolean hasNext() {
        refresh();
        return p != buffermax;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input;
        char[] output;

        input = "ab";
        sol.setContents(input.toCharArray());


        output = new char[10];
        System.out.println("Read N: " + sol.read(output, 1));
        for (char item : output)
            System.out.print(item);
        System.out.println();
        output = new char[10];
        System.out.println("Read N: " + sol.read(output, 2));
        for (char item : output)
            System.out.print(item);

    }
}