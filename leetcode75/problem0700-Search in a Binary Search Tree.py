"""
https://leetcode.com/problems/search-in-a-binary-search-tree/submissions/1651731375

probably didn't need to create a secondary search function but it felt cleaner
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:


        def search(root, val):

            if root == None:
                return None

            elif root.val == val:
                return root

            elif root.val > val:
                return search(root.left, val)

            elif root.val < val:
                return search(root.right, val)
        
        
        return search(root, val)
