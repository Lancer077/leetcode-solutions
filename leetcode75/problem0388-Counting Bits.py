"""
https://leetcode.com/problems/counting-bits/submissions/1555492134

pretty easy, definitely did not do it while partaking in substances of the be to the er variant
"""

class Solution(object):
    def countBits(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        def get_ones(num):
            counter = 0
            while num != 0:
                counter += (num % 2)
                num /= 2
            return counter
        
        arr = []
        for i in range(n+1):
            arr.append(get_ones(i))
        return arr
