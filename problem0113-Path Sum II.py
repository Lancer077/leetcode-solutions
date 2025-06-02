"""
https://leetcode.com/problems/path-sum-ii/submissions/1651849407


A bit more difficult than the previous one, but not too bad
Thought the tuple trick I used to prevent list immutability was kind of clever, but was also expecting that I'd need to turn the tuples back into lists afterwards
Thankfully that was not the case!
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        #take care of base case
        sum_lists = []
        cur_list = []
        def dfs(root, cur_list, target_sum, sum_lists):
            if root == None:
                return None

            cur_list.append(root.val)

            if root.left == None and root.right == None:
                if sum(cur_list) == target_sum:
                    cur_tup = tuple(cur_list) #since lists are updated by reference, without a tuple, we would be adding in the cur_list
                    sum_lists.append(cur_tup) #but then when we popped everything off the list, it would update the list and we'd have problems
                                              #this is fixed by turning the list into a tuple, which is immutable!
            else:
                if root.left != None:
                    dfs(root.left, cur_list, target_sum, sum_lists) #check left and right paths
                    cur_list.pop()
                if root.right != None:
                    dfs(root.right, cur_list, target_sum, sum_lists)
                    cur_list.pop()
        
        dfs(root, cur_list, targetSum, sum_lists)
        return sum_lists
