"""
https://leetcode.com/problems/tuple-with-same-product/submissions/1533665646
Daily problem 2/6/25

I have conflicting feelings towards this problem
On one hand, I was able to figure out the general strategy of using a hashmap to find how many times a given sum appears and use a formula at the end to get the combinations
On the other hand, figuring out just the formula to use was tricky for me, very tricky, but it's a good skill to have

First medium of February and the biggest time sink was figuring out ((n-1)n)/2 so I'm just hoping that's not a sign for things to come
"""
class Solution(object):
    def tupleSameProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        mult_vals = {}

        for i in range(len(nums)):
            for j in range(i):
                sum_val = (nums[i] * nums[j])
                if sum_val in mult_vals:
                    mult_vals[sum_val] += 1
                else:
                    mult_vals[sum_val] = 1

        total_sum = 0

        for key in mult_vals:
            if mult_vals[key] > 1:
                val = mult_vals[key]
                total_sum += (((val-1)*val)/2)*8
        
        return total_sum
        

        
