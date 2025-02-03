"""
https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/submissions/1530008192
daily problem 2/3/25
so despite this being an "easy" I had some troubles with it, mainly from my attempts to make things as simple as possible and avoid edge case hell
that still happened because edge case hell will always find those who do not sufficiently plan out their code
sometimes it's just easier to accept it, code a working solution, then go back and trim the fat
day 3 of the february challenge lets gooooo
"""

class Solution(object):
    def longestMonotonicSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #handle base case
        if(len(nums) == 1):
            return 1

        #if you need to write it twice, just make it a function
        def get_arr_code(a, b):
            if a < b:
                return 1
            elif a > b:
                return -1
            return 0

        cur_len = 1 #current increasing/decreasing subarray length
        global_max = 1 #overall max subarray length
        prev_arr_code = get_arr_code(nums[0], nums[1]) #grab the initial code so we can check it

        for i in range(len(nums)-1):

            cur_arr_code = get_arr_code(nums[i], nums[i+1]) #grab the next code so we can compare it to the previous

            if prev_arr_code != cur_arr_code:
                global_max = max(global_max, cur_len)
                cur_len = 2

            if cur_arr_code == 0:
                cur_len = 1
            elif prev_arr_code == cur_arr_code:
                cur_len += 1 #just increment the counter if we are increasing or decreasing

            prev_arr_code = cur_arr_code

        global_max = max(global_max, cur_len) #update global max
        return global_max
  
