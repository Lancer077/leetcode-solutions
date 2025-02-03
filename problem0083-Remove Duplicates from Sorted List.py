"""
https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/1530106026
unfortunately I still have not learned to consider all potential test cases, so I sacrificed 2 wrong submissions before getting there
genuinely a misclick to submit the third attempt too, I knew there was potential for optimization, but I've gotten so used to ctrl+enter that it is ingrained in me by now

This Thursday is my school's competitive coding tryouts/tournament so just knocking off some rust before I get there
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        cur_node = head

        if head == None:
            return head

        while cur_node.next != None:
            prev_node = cur_node
            cur_node = cur_node.next

            if prev_node.val == cur_node.val:
                prev_node.next = cur_node.next
                cur_node = prev_node
        
        return head


        
