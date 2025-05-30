"""
https://leetcode.com/problems/leaf-similar-trees/submissions/1649215343

Still getting back on my feet with recursion problems, I will probably stick to some easier ones for now until I really feel like I have the hang of things

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:

        def dfs(root, leaf_array):
            if root == None:
                return
            elif root.left == None and root.right == None:
                leaf_array.append(root.val)
                return
            else:
                dfs(root.left, leaf_array)
                dfs(root.right, leaf_array)
        
        arr1 = []
        arr2 = []

        dfs(root1, arr1) #gotta love pass by reference
        dfs(root2, arr2)

        return arr1 == arr2
