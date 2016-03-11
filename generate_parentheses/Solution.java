package generate_parentheses;

import java.util.*;

public class Solution {
    
    private HashMap<Character, Character> match = new HashMap<Character, Character>() {
        {
            put('(', ')');
//            put('[', ']');
//            put('{', '}');           
        }        
    };
        
    private boolean isValid(String s, int n) {
        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            char curchar = s.charAt(i);
            if(match.containsKey(curchar))
                st.push(curchar);
            else {
                if(st.isEmpty())
                    return false;
                if(match.get(st.pop()) != curchar)
                    return false;         
            }
        }
        if(s.length() < n)
            return true;
        else {
            if(st.isEmpty())
                return true;
            else
                return false;
        }
    }
    
    private char[] charenum = {'(', ')'};

    private void generateParenthesis(StringBuilder substr, ArrayList<String> container, int n) {
        if(substr.length() == n) 
            container.add(substr.toString());
        else {
            for(int i = 0; i < charenum.length; i++) {
                int len = substr.length();
                substr.append(charenum[i]);
                if(isValid(substr.toString(), n)) {
                    generateParenthesis(substr, container, n);                   
                }
                substr.deleteCharAt(len);
            }
        }
    }
   
    public List<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        generateParenthesis(new StringBuilder(), results, n * 2);
        return results;        
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> re = sol.generateParenthesis(3);
        for(String item : re)
            System.out.println(item);      
    }
}

