"""
https://leetcode.com/problems/find-the-difference-of-two-arrays/
https://leetcode.com/problems/find-the-difference-of-two-arrays/submissions/1517349084

Nice warm up for getting back into leetcode 75
Felt this solution was a nice mix of speed and simplicity
There will always be a faster solution out there, but I'm itching for problems that take more than 5 minutes

"""


class Solution(object):
    def findDifference(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[List[int]]
        """
        nums1_set = set()
        nums2_set = set()

        for num in nums1:
            nums1_set.add(num)
        for num in nums2:
            nums2_set.add(num)
        
        nums1_distinct = []
        nums2_distinct = []

        for num in nums1_set:
            if num not in nums2_set:
                nums1_distinct.append(num)
        for num in nums2_set:
            if num not in nums1_set:
                nums2_distinct.append(num)
        
        distinct = [nums1_distinct, nums2_distinct]

        return distinct
