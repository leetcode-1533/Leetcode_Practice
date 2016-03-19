# -*- coding: utf-8 -*-
"""
Created on Wed Jan 28 22:53:23 2015

@author: y1275963
"""


class Solution:
    # @param A, a list of integers
    # @param lower, an integer
    # @param upper, an integer
    # @return a list of strings
    def findMissingRanges(self, A, lower, upper):
        A.insert(0,lower-1)
        A.append(upper+1)
        li = []
        for index in range(len(A)-1):
            re = self.printer(A[index+1],A[index])
            if re != False:
                li.append(re)
        return li
            
            
    def printer(self,up,low):
        if up-low<=1:
            return False
        elif up - low == 2:
            return str(up-1)
        else:
            return str(low+1)+"->"+str(up-1)
        

if __name__ == "__main__":
    
    S = Solution()
    a = [0,1,3,50,75]
    lower = 0
    upper = 100
    test =  S.findMissingRanges(a,lower,upper)
    