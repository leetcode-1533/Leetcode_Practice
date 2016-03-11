package valid_parentheses;
import java.util.*;

public class Solution {
    
    private HashMap<Character, Character> match = new HashMap<Character, Character>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');           
        }        
    };
    
    private HashMap<Character, Boolean> isleft = new HashMap<Character, Boolean>() {
        {
            put('(', true);
            put('[', true);
            put('{', true);
            put(')', false);
            put(']', false);
            put('}', false);           
        }
    };
    
//    private boolean isLeft(char c) {
//        switch(c) {
//        case '(': return true;
//        case '[': return true;
//        case '{': return true;
//        case ')': return false;
//        case ']': return false;
//        case '}': return false;
//        default: return true; // never reached
//        }
//    }
    
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
//        for(char c : s.toCharArray()) {
//            if(isLeft(c))
//        } 
//        Discarded as doing this will involve "defensive copy" string is immutable
        for(int i = 0; i < s.length(); i++) {
            char curchar = s.charAt(i);
            if(isleft.get(curchar))
                st.push(curchar);
            else {
                if(st.isEmpty())
                    return false;
                if(match.get(st.pop()) != curchar)
                    return false;         
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
    

    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("(]"));   
    }
}
