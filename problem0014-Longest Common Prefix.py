"""
https://leetcode.com/problems/longest-common-prefix/submissions/1556235435

Unfortunately I needed two failed submissions to get this one, both times were things that I feel were silly errors on my part
Overall, a decent easy problem, think it seems a lot more difficult than it looks
"""

class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 1:
            return strs[0]

        if len(strs[0]) == 0:
            return ""

        for i in range(len(strs[0])):
            char_set = set()
            for s in strs:
                try:
                    char_set.add(s[i])
                except:
                    return strs[0][:i]
            if len(char_set) != 1:
                return strs[0][:i]
        return strs[0][:i+1]
