"""
https://leetcode.com/problems/count-good-nodes-in-binary-tree/submissions/1651776056

Still feels like the DFS part of the problem is the hardest part of it
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        #depth first search

        #helper function to keep things cleaner
        def dfs(root, val):
            if root == None:
                return 0

            #setting the value to one here will functionally provide incrementation when we get to the recursive calls
            if root.val >= val:
                good_node_count = 1
                val = root.val
            else:
                good_node_count = 0
            
            #recursive calls
            good_node_count += dfs(root.left, val)
            good_node_count += dfs(root.right, val)

            return good_node_count
        
        return dfs(root, root.val)
        
        
