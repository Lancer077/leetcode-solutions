"""
leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/
leetcode.com/problems/count-prefix-and-suffix-pairs-i/submissions/1502322991/?envType=daily-question&envId=2025-01-08

After day 21 of Advent of Code 2024, leetcode doesn't seem that bad after all

Also I realized that I should start doing these in python because that's probably the language I'm going to end up using the most going forward
"""

class Solution(object):
    def countPrefixSuffixPairs(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        counter = 0
        for i in range(len(words)):
            for j in range(i):
                if words[i].startswith(words[j]) and words[i].endswith(words[j]):
                    counter += 1



        return counter
        
