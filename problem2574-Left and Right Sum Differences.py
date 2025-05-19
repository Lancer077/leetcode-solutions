"""
https://leetcode.com/problems/left-and-right-sum-differences/submissions/1638591281

It's a little ugly but still gets me that coveted 100% time efficiency and 55% space efficiency
"""
class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:

        answer = []
        left_prefix  = 0
        right_prefix = sum(nums[1:]) #ignore this, pretend there's only one for loop in this code (the sum function is optimized anyways)

        nums.append(0)  #artifically adding a zero at the end because each prefix functionally cuts off the opposite end of the array
        for i in range(len(nums)-1):    #left prefix will pretend we didn't add the extra zero by doing length-1
            answer.append(abs(left_prefix - right_prefix)) #update the naswer array before updating the prefixes
            left_prefix += nums[i]
            right_prefix -= nums[i+1]

        return answer


