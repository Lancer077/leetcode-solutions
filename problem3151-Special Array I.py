"""
https://leetcode.com/problems/special-array-i/submissions/1527599315

daily problem Feb 1, 2025

I was waiting for some blood work in the hospital and figured this was a half decent use of my time
I then discovered how absolutely horrible the mobile phone leetcode experience is
But thankfully today was an easy problem which didn't give me any trouble 
I've wanted to complete a monthly coding challenge for some time and February seems like the month to do it

"""

class Solution(object):
    def isArraySpecial(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        for i in range(len(nums)-1):
            if nums[i] % 2 == nums[i+1] % 2:
                return False
        return True
                            