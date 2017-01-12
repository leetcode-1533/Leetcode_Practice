package guess_number_higher_or_lower;

/**
 * Created by y1275963 on 1/11/17.
 */
public class Solution extends GuessGame {
    Solution(int num) {
        super(num);
    }

    public int guessNumber(int n) {
        int ln = 1;
        int rn = n;
        int mean = 0;

        while ((rn - ln) > 1) {
            mean = ln + (rn - ln) / 2;
            int re = guess(mean);
            if(re == 0)
                return mean;
            else if(re == -1)
                rn = mean;
            else
                ln = mean;
        }
        if (guess(ln) == 0)
            return ln;
        if (guess(rn) == 0)
            return rn;
        return 0; // never reached
    }

    public static void main(String[] args) {
        Solution sol = new Solution(5);
        int test = sol.guessNumber(10);
        System.out.println(test);
    }
}

class GuessGame {
    int root;

    GuessGame(int init) {
        root = init;
    }

    public int guess(int num) {
        if (num < root)
            return 1;
        else if (num > root)
            return -1;
        else
            return 0;
    }
}