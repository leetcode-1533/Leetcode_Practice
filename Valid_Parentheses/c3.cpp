/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

#define STK_SZ 50
#include <string>
#include <iostream>
using namespace std;

class Solution {
        public:
                bool isValid(string &s) {
                        const char ele = pop_str(s);
                        if(ele == s.back()){
                                s.pop_back();
                                return true;
                        }
                        if( s.length() == sizeof(char)){
                                return false;
                        }
                        else{
                                bool con1 = isValid(s);
                                bool con2 = (ele == pop_str(s));
                                return (con1 && con2);
                        }
                }
        private:
                char pop_str(string &s){
                        char temp = s.back();
                        s.pop_back();
                        return temp;
                }
};

int main(){
        string s("[]");
        Solution tm = Solution();
        cout << s;
        cout << tm.isValid(s);
        return 0;
}
