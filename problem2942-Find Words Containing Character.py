"""
https://leetcode.com/problems/find-words-containing-character/submissions/1643322306

Daily Problem 5.24.2025
Quite possibly the easiest problem on leetcode
"""
class Solution:
    def findWordsContaining(self, words: List[str], x: str) -> List[int]:
        
        #could use the premade python "in" function but that's too easy
        #although to be fair this implementation is 5 lines so I guess there's not much of a difference
        def check_target_letter(word, target_letter):
            for char in word:
                if char == target_letter:
                    return True
            return False

        valid_locations = []
        for index in range(len(words)):
            if check_target_letter(words[index], x):
                valid_locations.append(index)

        return valid_locations
