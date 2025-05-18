"""
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/submissions/1637439579
nice warm-up to knock the rust off

"""

class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        digit_prod = 1
        digit_sum  = 0

        #thank you commutative rule of addition and multiplication 
        while n > 0:
            digit_prod *= n % 10
            digit_sum  += n % 10
            n = n // 10

        return (digit_prod - digit_sum)
            
