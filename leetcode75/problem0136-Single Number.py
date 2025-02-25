"""
https://leetcode.com/problems/single-number/submissions/1555485403

Was bored (attending a class I'm not actually in because I wanted to learn cybersecurity stuff)
Set/hashmap seemed to be the best/easiest approach
Occasionally I'm right
"""

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        num_set = set()

        for num in nums:
            if num in num_set:
                num_set.remove(num)
            else:
                num_set.add(num)
        
        iterator = iter(num_set)

        single = next(iterator)

        return single

        
