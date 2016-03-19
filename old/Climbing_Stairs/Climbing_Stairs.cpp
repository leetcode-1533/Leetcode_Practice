//
//  main.cpp
//  c4
//
//  Created by y1275963 on 1/17/15.
//  Copyright (c) 2015 y1275963. All rights reserved.
//

#include <iostream>
#include <array>

using namespace std;

class Solution{
public:
    int climbStairs(int n){
        int way = 0;
        if(n-1 >= 0){
            way = way + climbStairs(n-1);
        }
        if(n-2 >= 0){
            way = way+ climbStairs(n-2);
        }
        if(n==0){
            return 1;
        }
        return way;
    }
    int smartClimb(int n){
        const 
        array<int,n>
    }
};
int main(int argc, const char * argv[])
{

    // insert code here...
    Solution test = Solution();
    std::cout << test.smartClimb(2);
    std::cout << "Hello, World!\n";
    return 0;
}

