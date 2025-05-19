"""
https://leetcode.com/problems/type-of-triangle/submissions/1638331929

daily problem 5.19.2025
fun problem, but its always a fun problem when I get to utilize sets
looking back, I could have made the set before I removed the longest side or just could have added the longest side to the set directly instead of adding it back into the list
either way, I still got 100% time efficiency and 50% space efficiency so I'm not too worried overall
"""
class Solution:
    def triangleType(self, nums: List[int]) -> str:

        #ensure valid triangle
        longest_side = max(nums)
        nums.remove(longest_side)
        if longest_side >= sum(nums):
            return "none"
        
        #since we removed the longest side from the list, we will add it back in
        nums.append(longest_side)

        #sets are one of the data structure GOATS
        triangle_set = set(nums)

        if len(triangle_set) == 1:
            return "equilateral"
        if len(triangle_set) == 2:
            return "isosceles"
        return "scalene"
        

        
