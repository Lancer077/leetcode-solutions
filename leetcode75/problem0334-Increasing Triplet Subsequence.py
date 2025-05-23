"""
https://leetcode.com/problems/increasing-triplet-subsequence/submissions/1642302670

Finally figured out how to do this one, definitly could be cleaner but I also don't really ever want to look at this problem again
"""

class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        first = None
        second = None
        third = None

        for number in nums:
            if first == None or number <= first:
                first = number
            elif second == None or number <= second:
                second = number
            elif third == None or number <= third:
                third = number
            if third != None and third > second and second > first:
                return True
        return False
