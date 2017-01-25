package anagrams;

/**
 * Created by y1275963 on 1/25/17.
 */
import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> container = new HashMap<>();
        for (String item : strs) {
            String toorder = toorder(item);
            if (container.containsKey(toorder)) {
                container.get(toorder).add(item);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(item);
                container.put(toorder, temp);
            }
        }
        ArrayList<List<String>> re = new ArrayList<>();
        for (List<String> item : container.values()) {
            re.add(new ArrayList<>(item));
        }
        return re;
    }

    private String toorder(String intput) {
        char[] temp = intput.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static void main(String[] args) {

    }
}