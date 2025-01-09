"""
Initially solved it just by using the string.startswith(substring) method like yesterday's daily question and if I was in a serious environment I would certianly do that because its faster and more readable
however, using builtin libraries to do the entire problem feels a bit like cheating sometimes? Especially when the problem is trivial
leetcode.com/problems/counting-words-with-a-given-prefix
leetcode.com/problems/counting-words-with-a-given-prefix/submissions/1503253750/?source=submission-ac
"""

class Solution(object):
    def prefixCount(self, words, pref):
        counter = len(words)
        pref_len = len(pref)
        for word in words:
            if pref_len > len(word):
                counter -= 1
                continue
            for i in range(pref_len):
                if word[i] != pref[i]:
                    counter -= 1
                    break
        return counter
        
