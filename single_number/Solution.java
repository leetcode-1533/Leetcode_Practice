package single_number;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/*
 *  
 *  My ideas : 
 *  1. sort the list
 *  
 *  From the tutorial : 
 *  1. use hash map : more faster
 *  2. using an bag : more faster : log(n) speed if I am not wrong
 *  
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for(int item : nums) {
            if(map.contains(item)) 
                map.remove(item);
            else
                map.add(item);
        }
        
        Iterator<Integer> temp = map.iterator();
        
        return temp.next();
  
    }
    
//    hashmap version
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
//        for(int item : nums) {
//            if(map.get(item) == null) 
//                map.put(item, 1);
//            else 
//                map.put(item, map.get(item) + 1);
//        }
//        
//        for(Integer item : map.keySet()) {
//            if(map.get(item) == 1)
//                return item;
//        }
//        return 0;        
//    }
//    
    
    public static void main(String[] args) {
        
    }

}
