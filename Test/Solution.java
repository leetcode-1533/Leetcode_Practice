package Test;

/**
 * Created by y1275963 on 6/13/16.
 */
import utility.Reader4;

public class Solution extends Reader4 {
    private char[] buffer = new char[4];
    int offset = 0, bufsize = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            if (bufsize == 0) { bufsize = read4(buffer); eof = bufsize < 4;
            }
            int bytes = Math.min(n - readBytes, bufsize); System.arraycopy(buffer /* src */, offset /* srcPos */,
                    buf /* dest */, readBytes /* destPos */, bytes /* length */);
            offset = (offset + bytes) % 4;
            bufsize -= bytes;
            readBytes += bytes;
        }
        return readBytes;
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