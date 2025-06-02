"""
https://leetcode.com/problems/path-sum/submissions/1651833146

Was working on the leetcode 75, got to path sum III, and decided to do the first two problems to get a better overall understanding of the problem structure

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:

        #take care of base case

        def dfs(root, cur_sum, target_sum):
            if root == None:
                return False

            cur_sum += root.val
            if root.left == None and root.right == None:
                if cur_sum == target_sum:
                    return True

            else:
                left = dfs(root.left, cur_sum, target_sum) #check left and right paths
                right = dfs(root.right, cur_sum, target_sum)
                if left or right:
                    return True
            return False #handles edge cases
        
        return dfs(root, 0, targetSum)
