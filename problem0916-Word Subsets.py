"""
https://leetcode.com/problems/word-subsets/
https://leetcode.com/problems/word-subsets/submissions/1504420700/

Took longer than I would have liked, both to code and to run but I did get there in the end
not super happy with the final result, but not exactly dissappionted in myself either


"""


class Solution(object):
    def wordSubsets(self, words1, words2):
        """
        :type words1: List[str]
        :type words2: List[str]
        :rtype: List[str]
        """

        def word_to_letter_map(word):
            letter_map = {}
            for letter in word:
                if letter in letter_map:
                    letter_map[letter] += 1
                else:
                    letter_map[letter] = 1
            return letter_map


        matching = []

        #setup, grab the max appearances for each letter in words2
        words2_letter_map = {}
        for word in words2:
            substring_map = word_to_letter_map(word)
            for entry in substring_map:
                if entry in words2_letter_map:
                    if substring_map[entry] > words2_letter_map[entry]:
                        words2_letter_map[entry] = substring_map[entry]
                else:
                    words2_letter_map[entry] = substring_map[entry]
        #loop through each word in words1
        for word in words1:
            valid = True
            word1_letter_map = word_to_letter_map(word)
            
            print(word1_letter_map, words2_letter_map)

            for entry in words2_letter_map:
                if entry not in word1_letter_map:
                    valid = False
                elif word1_letter_map[entry] < words2_letter_map[entry]:
                    valid = False

            if valid:
                matching.append(word)
        return matching
                    
            
        
