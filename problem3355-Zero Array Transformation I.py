"""
https://leetcode.com/problems/zero-array-transformation-i/submissions/1639526464

Daily problem 5.20.2025
95% time efficiency!!!
Needed to look up how to do this, but basically just a prefix sum and a difference array question dressed up together in a trench coat
Kinda happy with how clean the code came out to be
"""


class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        
        #it took a while but I understand it now, and in my opinion, I have a much cleaner implementation than anything else I've found
        delta_array = [0] * (len(nums) + 1) #create an array to store all the queries in one array

        for start, end in queries:      #loop through each query
            delta_array[start] += 1     #increment at the start of the query
            delta_array[end+1] -= 1     #decrement at the end of the query
        
        threshold = 0   #prefix sum but I didn't want to use the same term for it as everyone else
        for index in range(len(nums)): 
            threshold += delta_array[index]     #incrementing the threshold value (or decrementing if the index value is negative)
            if nums[index] > threshold:         #if the nums value is too big to subtract to 0, break the loop 
                return False
        return True                             #if we get to the end of the loop, then we know the entire array passes the checks

        
