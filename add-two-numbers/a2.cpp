#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
            int adding_temp;
            int reg = 0;
            ListNode *head = new ListNode(0);
            ListNode *original = head;
            while( l1 != NULL &&  l2 != NULL){
                    ListNode * point_next = new ListNode(0);
                    head->next = point_next;
                    if(adding(l1->val+reg,l2->val,&adding_temp)){
                                    reg = 1;
                                    head->val = adding_temp;
                    }
                    else{
                    reg = 0;
                    head->val = adding_temp;
                    }
                    l1 = l1->next;
                    l2 = l2->next;
                    head = point_next; 
            }
            if(reg != 0){
                    //cout << "test" << reg;
                    ListNode * point_next = new ListNode(reg);
                    head->next = point_next;
            }
            return original;
    }
private:
    bool adding(int x, int y, int * ans){
            *ans = x + y;
            if (*ans >= 10){
                    *ans = *ans - 10;
                    return true;
                    }
            else{
                    return false;
    }
    }
};
int main(){
        ListNode * test1 = new ListNode(5);
        ListNode * test2 = new ListNode(5);
        Solution hk = Solution();
        ListNode * re = hk.addTwoNumbers(test1,test2);
        cout << re->val;
        cout << (re->next)->val;
        return 0;

}
