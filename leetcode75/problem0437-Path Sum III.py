"""
https://leetcode.com/problems/path-sum-iii/submissions/1651875780

Definitely could have been a faster solution using dictionaries, but my solution was accepted
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:

        def dfs(root, cur_list, target_sum, counter):
            if root == None:
                return 0

            cur_list.append(root.val)
            cur_sum = 0
            for i in range(len(cur_list)): #might get a TLE for this implementation
                cur_sum += cur_list[len(cur_list)-i-1]
                if cur_sum == target_sum:
                    counter += 1            
            
            if root.left != None:
                counter += dfs(root.left, cur_list, target_sum, 0) #check left and right paths
                cur_list.pop()
            if root.right != None:
                counter += dfs(root.right, cur_list, target_sum, 0)
                cur_list.pop()
            return counter
        
        counter = dfs(root, [], targetSum, 0)
        return counter
