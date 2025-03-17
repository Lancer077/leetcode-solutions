"""
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/1576923681

Didn't want to use python's find() because that kinda feels like cheating but I guess I consider string splicing/indexing fair game
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        needle_len = len(needle)
        for index in range(len(haystack)):
            if haystack[index] == needle[0]:
                if haystack[index:index+needle_len] == needle:
                    return index
        return -1
