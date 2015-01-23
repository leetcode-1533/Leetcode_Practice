class Solution:
    def single_atoi(self,str):
        try:
            if(int(str)-float(str) == 0):
                return int(str)
            else:
                return float(str)
        except (ValueError),e:
            return 0
    def atoi(self,str):
        new_str = re.match("[^A-Za-z]*",str).group(0)
     #   print new_str
        new_str = new_str.strip()
        new_str = re.match("(\-?)(\+?)(\d)*",new_str).group(0)
        #print new_str
        re_test = re.match("\+",new_str)
        if re_test is not None:
            new_str = new_str[1:]
        num = self.single_atoi(new_str)
        if(num > 2**31-1):
            return 2**31-1
        elif(num < -2**31):
            return -2**31
        return num
