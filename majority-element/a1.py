# -*- coding: utf-8 -*-
"""
Created on Sun Jan 11 16:49:42 2015

@author: y1275963
"""
class Solution:
    def cel_dev(self,x,y):
        return x-x//y
        
    def alpartition(self,my_str):
        signal = 0
        i = 0
        j = len(my_str)
        while i < j:
                if signal == 0 :
                    while 1:
                        j = j - 1
                        if my_str[j] <= my_str[i]:
                            break
                    signal = 1
                else:
                    while 1:
                        i = i + 1
                        if my_str[j] <= my_str[i]:
                            break
                    signal = 0
                # print my_str,i,j
                my_str[j],my_str[i] = my_str[i],my_str[j]
        my_str[j],my_str[i] = my_str[i],my_str[j]
        return i
     
    def sort(self,my_str):
        if len(my_str)>1:
            tick = self.alpartition(my_str)
            # print my_str,my_str[0:tick:],my_str[tick+1::],tick
            my_str[0:tick:]=self.sort(my_str[0:tick:])
            my_str[tick+1::]=self.sort(my_str[tick+1::])
        return my_str
        
    def majorityElement(self,num):
        para = self.cel_dev(len(num),2)
        list_sort = self.sort(num)
        last_item = list_sort[0]
        last_index = 0
        for index,item in enumerate(list_sort):
            if item != last_item:
                length = index - last_index
                if length >= para:
                    return last_item
                else:
                    last_item = item
                    last_index = index
        return last_item
            
if __name__=="__main__":
    a = [3,5,3]
    test = Solution()
    print test.majorityElement(a)
        