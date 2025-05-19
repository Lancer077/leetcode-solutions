"""
https://leetcode.com/problems/prime-in-diagonal/submissions/1638258759

Edge cases with small numbers tripped me up but we got there

"""

class Solution:
    def diagonalPrime(self, nums: List[List[int]]) -> int:
        
        largest_prime = 0

        def check_if_prime(num):
            #is this cheating? nahhhhhhhhhh
            #it's just mathematical induction
            if num < 2:
                return False
            if num < 4:
                return True

            iterations = math.floor(sqrt(num))
            for i in range(iterations):
                if num % (i+2) == 0:
                    return False
            return True

        for row in range(len(nums)):
            num_a = nums[row][row]
            num_b = nums[row][len(nums) - row - 1]

            if num_a > largest_prime and check_if_prime(num_a):
                largest_prime = num_a
            if num_b > largest_prime and check_if_prime(num_b):
                largest_prime = num_b
        
        return largest_prime
