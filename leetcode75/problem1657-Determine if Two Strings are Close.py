"""
https://leetcode.com/problems/determine-if-two-strings-are-close/submissions/1553978717

This one I was happy to solve without any hints or looking at the discussion or anything
I even had the right idea from the start to use a hashmap to store the number of times a letter appears and approach it from more of a math angle as opposed to brute force
I did need two submissions because I didn't read the question carefully enough, but I don't consider that to be a huge deal

"""


class Solution(object):
    def closeStrings(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: bool
        """
        def build_map(word):
            word_map = {}
            for letter in word:
                if letter not in word_map:
                    word_map[letter] = 0
                word_map[letter] += 1
            return word_map

        word_1_map = build_map(word1)
        word_2_map = build_map(word2)

        keys_1 = word_1_map.keys()
        keys_2 = word_2_map.keys()
        keys_1.sort()
        keys_2.sort()

        vals_1 = word_1_map.values()
        vals_2 = word_2_map.values()
        vals_1.sort()
        vals_2.sort()

      
        return vals_1 == vals_2 and keys_1 == keys_2
