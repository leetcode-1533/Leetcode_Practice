package single_number;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashMap;
/*
 *  
 *  My ideas : 
 *  1. sort the list
 *  
 *  From the tutorial : 
 *  1. use hash map
 *  2. using an bag
 *  
 */
public class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for(int item : nums) {
            if(map.get(item) == null) 
                map.put(item, 1);
            else 
                map.put(item, map.get(item) + 1);
        }
        
        for(Integer item : map.keySet()) {
            if(map.get(item) == 1)
                return item;
        }
        return 0;        
    }
    
    public static void main(String[] args) {
        
    }

}
