"""
https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/submissions/1541921161
Daily problem 2/13/25

Data structures with names starting with "H" 🤝 being absolutely legendary when it comes to solving hard coding problems
Heaps are one of those structures that I ignore probably more than I should, but today I found them to be incredibly helpful
This one took a couple of tries but overall the final code was super simple
Almost halfway done with February!!!
"""
class Solution(object):
    def minOperations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        heapq.heapify(nums)
        
        counter = 0
        while nums[0] < k:
            counter += 1
            x = heapq.heappop(nums)
            y = heapq.heappop(nums)
            heapq.heappush(nums, x*2+y)
        return counter


