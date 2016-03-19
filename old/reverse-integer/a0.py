class Solution:
    # @return an integer
    def reverse(self,x):
        i = x
        if i >= 2**31 -1 or i <= -2**31 +1 :
            i = 0
        flag = 0
        if i < 0:
            flag = 1
        i = abs(i)
        a = list()
        while i>0:
            a.append(i%10)
            i = i / 10
        temp = 0
        for index,item in enumerate(reversed(a)):
            temp = temp + item*10**index
        if flag == 1:
            temp = - temp
        if temp >= 2**31 - 1 or temp <= -2**31 +1 :
            temp = 0
        return temp
