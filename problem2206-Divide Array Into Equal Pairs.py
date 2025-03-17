"""
Daily problem 3/17/25
https://leetcode.com/problems/divide-array-into-equal-pairs/submissions/1576885424

Nice easy problem, definitely a lot of ways to solve it but using a set was the fastest way I could think of to solve it
Could have used a hashmap and incremented each time we found a given value but that would have required another loop at the end
also I just like working with sets in python
"""

class Solution(object):
    def divideArray(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) % 2 == 1:
            return False
        #set approach
        pairs = set()
        for n in nums:
            if n in pairs:
                pairs.remove(n)
            else:
                pairs.add(n)
        
        if len(pairs) == 0:
            return True
        return False
