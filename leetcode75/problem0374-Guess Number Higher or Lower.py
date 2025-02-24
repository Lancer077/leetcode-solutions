"""
https://leetcode.com/problems/guess-number-higher-or-lower/submissions/1554180324

Kinda silly that checking if the n value is also the guess is a MASSIVE speedup but I guess that's just how the testcases are designed
"""

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if guess(n) == 0:
            return n

        lower_bound = 1
        upper_bound = n
        result = None
        
        while result != 0:
            my_guess = ((upper_bound + lower_bound) / 2)
            result = guess(my_guess)

            if result == 1:
                lower_bound = my_guess + 1
            elif result == -1:
                upper_bound = my_guess - 1

        return my_guess        

        
