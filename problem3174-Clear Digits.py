"""
https://leetcode.com/problems/clear-digits/submissions/1538550900
daily problem 2/10/25

not bad, was an okay problem, once I thought about it for a moment, a stack was the obvious choice
There might be a faster way to implement the algorithm, to prevent needing to loop through twice and not do string manipulation (this is very slow in python) but I don't have any complaints
"""

class Solution(object):
    def clearDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        for entry in s:
            if entry.isalpha():
                stack.append(entry)
            else:
                stack.pop()

        updated = ""
        for entry in stack:
            updated += entry
        return updated        
