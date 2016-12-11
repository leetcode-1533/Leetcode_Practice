package heater;

/**
 * Created by y1275963 on 12/10/16.
 */
import java.util.Arrays;
import java.util.*;

public class Solution {
    public static int findRadius(int[] houses, int[] heaters) {
        int re = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                int insert_point = -(index + 1);
                int l_dist = Integer.MAX_VALUE;
                int r_dist = Integer.MAX_VALUE;
                if (insert_point > 0)
                    l_dist = house - heaters[insert_point - 1];
                if (insert_point < heaters.length)
                    r_dist = heaters[insert_point] - house;
                if (Math.min(l_dist, r_dist) > re)
                    re = Math.min(l_dist, r_dist);
            }
        }
        return re;
    }

    public static void main(String[] args) {
//        System.out.println(
        int re = Solution.findRadius(new int[]{1}, new int[]{1, 2, 3, 4});
        System.out.println(re);

    }
}
