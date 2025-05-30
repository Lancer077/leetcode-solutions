"""
https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1649207070

As I stated in the code, my skills with recursive functions such as BFS/DFS definitely leave something to be desired, but I do not intend
for it to stay this way
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        
        #I did need to look up how to do this one, it has been a fairly long time since I have had to 
        #code anything substantial using DFS/BFS and I know these types of algorithms are easily 
        #my weakest area, which is why I am done being scared of them and will start patching up the weak spot 

        if root == None:
            return 0
        
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))
