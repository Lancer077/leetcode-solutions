"""
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/submissions/1528754133

daily problem Feb 2, 2025
neat little problem, a little more difficult than I would have expected from an easy but that's how it goes I guess
I'm enjoying the easy ones while they last
"""

class Solution(object):
    def check(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        rotated = False #will update when we need to rotate
        rotate_loc = -1
        nums_len = len(nums)
        for i in range(nums_len-1):
            if nums[i] > nums[i+1]:
                if not rotated:
                    rotated = True
                    rotate_loc = i
                else: #if we need to rotate twice, then false
                    return False
        
        rotate_loc += 1 #had some off by one stuff and decided to make things a bit more intuitive

        if rotate_loc == -1: #if we had a completely sorted array, no need to rotate
            return True
        #test if we can rotate
        for i in range(nums_len-1):  #felt pretty clever using the mod trick here, although I'm sure that was the intended idea
            if nums[(i + rotate_loc) % nums_len] > nums[(i + 1 + rotate_loc) % nums_len]:
                return False
        return True

        
        
                
                    
