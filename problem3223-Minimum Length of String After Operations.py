"""
https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
https://leetcode.com/problems/minimum-length-of-string-after-operations/submissions/1507420978

essentially perfect time efficiency, okay space efficiency although I'm not really sure how the space could be improved without decreasing code readability
thought the absolute value trick was clever


"""

class Solution(object):
    def minimumLength(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_map = {}
        for letter in s:
            if letter in char_map:
                char_map[letter] += 1
            else:
                char_map[letter] = 1
        
        
        counter = 0
        for char in char_map:
            char_count = char_map[char]
            if char_count > 2:  #if char_count is 1 or 2, just add that
                char_count %= 2  #if we get 0 here we want to add 2, if we get 1 here we want to add 1
                char_count = abs(char_count-2) #here is my workaround because an IF statement feels overkill here
            counter += char_count
            

        return counter
