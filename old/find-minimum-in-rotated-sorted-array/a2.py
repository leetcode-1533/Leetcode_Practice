# -*- coding: utf-8 -*-
"""
Created on Fri Jan 30 21:14:31 2015

@author: y1275963
"""

class Solution:
    def findMin(self,num):            
        start = num[0]
        middle = num[len(num)/2]
        final = num[-1]
        if len(num)<=3:
            return self.find3min(start,middle,final)
        else:        
            if start < middle and middle < final:
                return start
            if start < middle and middle > final:
                new_list = num[len(num)/2:]
            if start > middle :
                new_list = num[:len(num)/2+1]
            return self.findMin(new_list)
    def find3min(self,fir,sec,thi):
        new_list= [fir,sec,thi]
        return sorted(new_list)[0]
        
        

if __name__ == "__main__":
    S = Solution()
    array_test = [0]
    for item in range(4):
        int_temp = array_test.pop()
        array_test.insert(0,int_temp)
    array_test = [4,5,1,2,3]
    print array_test
    print S.findMin(array_test)