"""
https://leetcode.com/problems/count-number-of-bad-pairs/submissions/1537240812
Daily problem 2/9/25

Wanted to just get this one done before the Super Bowl, needed some assistance mainly because I've never used a Counter, but I realize that I probably should have used it by now
Better late than never I guess
Overall, it was a really neat problem realizing that j-i = nums[j] - nums[i] can be transformed into nums[j] - j = nums[i] - i and I probably would have taken way too long to figure that one out just by myself
"""
class Solution(object):
    def countBadPairs(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = Counter()
        answer = 0
        for i in range(len(nums)):
            answer += i - count[i-nums[i]]
            count[i-nums[i]] += 1
        return answer
        
