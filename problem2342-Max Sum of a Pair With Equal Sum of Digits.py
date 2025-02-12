"""
https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/submissions/1540666872
Daily problem 2/12/25

I felt like I somewhat got my mojo back with this one, I was able to solve it without needing the hints and it felt pretty good
I know my if statement blocks are a little messy, but I felt like that was the easiest way to solve the problem
Also I think commenting the code, even when it's just for me, definitely helps with the if statement mess

"""

class Solution(object):
    def maximumSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        def get_digit_sum(n):
            total = 0
            while n > 0:
                temp = n % 10
                n /= 10
                total += temp
            return total

        sums = {}

        for num in nums:
            digit_sum = get_digit_sum(num)
            if digit_sum in sums:
                #if we are dealing with a list of size 1
                if len(sums[digit_sum]) == 1: 
                    #if the first number is bigger than num
                    if sums[digit_sum][0] > num:
                        sums[digit_sum].append(num)
                    #if num is bigger than the first number
                    else:
                        temp = sums[digit_sum][0]
                        sums[digit_sum][0] = num
                        sums[digit_sum].append(temp)
                #if we are dealing with a list of size 2
                else:
                    #if num is bigger than the first number
                    if num > sums[digit_sum][0]:
                        sums[digit_sum][1] = sums[digit_sum][0]
                        sums[digit_sum][0] = num
                    #if num is bigger than the second number
                    elif num > sums[digit_sum][1]:
                        sums[digit_sum][1] = num
            else:
                sums[digit_sum] = [num]
        
        max_val = -1

        for key in sums:
            if len(sums[key]) == 2:
                max_val = max(max_val, sums[key][0] + sums[key][1])
        
        return max_val

