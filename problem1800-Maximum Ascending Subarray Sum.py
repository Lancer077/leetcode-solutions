"""
https://leetcode.com/problems/maximum-ascending-subarray-sum/submissions/1530453255
Daily problem 2/4/25

Got this one out of the way early, was noticeably easier than the problem from the previous day
Submitted three times because I misread the first question on the first one, and realized an optimization on the second
overall, not too bad

"""

class Solution(object):
    def maxAscendingSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        
        global_max = 0
        cur_total = 0

        for i in range(len(nums)-1):
            cur_total += nums[i]
            if nums[i] >= nums[i+1]:
                global_max = max(global_max, cur_total)
                cur_total = 0

        if nums[-2] < nums[-1]:
            cur_total += nums[-1]

        global_max = max(global_max, cur_total)

        return global_max
