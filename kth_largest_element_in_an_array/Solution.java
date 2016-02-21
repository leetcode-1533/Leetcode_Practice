package kth_largest_element_in_an_array;

import edu.princeton.cs.algs4.StdOut;
// https://leetcode.com/problems/kth-largest-element-in-an-array/

public class Solution {
    int N = 0;
    int [] pq;
    
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        pq = new int[size];
        for(int i = 0; i < size; i++) {
            insert(nums[i]);
        }
        
        return 0;
    }
    
    public void insert(int x) {
        pq[++N] = x;
        swim(N);
    }
    
    public int delMax() {
        int max = pq[1];
        exch(1, N--);
        sink(1);
        return max;
    }
    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

     private void swim(int k) {
         while (k > 1 && less(k/2, k)) {
             exch(k, k/2);
             k = k/2;
         }
     }

     private void sink(int k) {
         while (2*k <= N) {
             int j = 2*k;
             if (j < N && less(j, j+1)) j++;
             if (!less(k, j)) break;
             exch(k, j);
             k = j;
         }
     }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/
     private boolean less(int i, int j) {
         return (pq[i] < pq[j]);
     }

     private void exch(int i, int j) {
         int swap = pq[i];
         pq[i] = pq[j];
         pq[j] = swap;
     }
     
     public static void main(String[] args) {
         Solution sol = new Solution();
         int[] input = {3, 2, 1, 5, 6, 4};
         sol.findKthLargest(input, 1);
     }
}
