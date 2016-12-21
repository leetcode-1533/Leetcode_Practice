package first_bad_version;

/**
 * Created by y1275963 on 12/20/16.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarysearch(0, n);
    }

    private int binarysearch(int start, int end) {
        if (end - 1 > start) {
            int mid = start + (end-start) / 2;
            if (super.isBadVersion(mid)) {
                return binarysearch(start, mid);
            } else {
                return binarysearch(mid, end);
            }
        }

        if (end - 1 == start) // tail condition
            return end;
        else
            return -1;
    }

    public static void main(String[] args) {
        int[] inputs = {1,22,34,40,5232,6342342,71231, 2126753390};
        int[] targets = {1, 10, 20, 25, 323, 45454, 23232, 1702766719};
//        int[] inputs = {2126753390};
//        int[] targets = {1702766719};
        Solution Sol = new Solution();

        for (int i = 0; i < inputs.length; i++) {
            Sol.firstBadVersion = targets[i];
            int re = Sol.firstBadVersion(inputs[i]);
            System.out.printf("Input: %d, target: %d, results: %d\n", inputs[i], targets[i], re);
        }
    }
}