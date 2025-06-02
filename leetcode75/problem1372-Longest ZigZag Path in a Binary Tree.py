"""
https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/submissions/1652092678

A large part of me wishes I did more of these leetcode problems back when I was learning this type of programming back in college, I should have reinforced my skills then instead of letting my skills drop 

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.max_len = 0 #little trick I stole so I could functionally update integers by reference, will definitely be useful going forward
        
        def zig_zag_search(root, prev_direction, cur_len):
            if not root:
                return
            self.max_len = max(self.max_len, cur_len)
            if prev_direction == "left":
                zig_zag_search(root.right, "right", cur_len + 1)
                zig_zag_search(root.left, "left", 1)
            else:
                zig_zag_search(root.right, "right", 1)
                zig_zag_search(root.left, "left", cur_len + 1)
        
        zig_zag_search(root, "left", 0)
        return self.max_len
