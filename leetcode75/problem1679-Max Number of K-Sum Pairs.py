"""
https://leetcode.com/problems/max-number-of-k-sum-pairs/submissions/1642340958


"""
class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        #pretty obvious hashing
        
        operation_count = 0
        differences = {} 
        for n in nums:
            if n not in differences or differences[n] < 1: #this part could probably be improved to look nicer but basically it is just a hashmap of differences to allow for O(n) time complexity
                if k-n in differences:
                    differences[k-n] += 1
                else:
                    differences[k-n] = 1
            else:
                differences[n] -= 1
                operation_count += 1
           
        return operation_count

