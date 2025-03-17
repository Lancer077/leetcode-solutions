"""
https://leetcode.com/problems/merge-two-sorted-lists/submissions/1576913910

certianly not the prettiest or fastest or best memory efficient
I'm not going to pretend that linked lists aren't my weak area
"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        #handle edge cases
        if list1 is None and list2 is None:
            return None
        if list1 is None:
            return list2
        if list2 is None:
            return list1

        head = ListNode()

        #base case->head
        if list1.val < list2.val:
            head = list1
            list1 = list1.next
        else:
            head = list2
            list2 = list2.next
        cur_node = head
        
        while list1 is not None and list2 is not None:
            if list1.val < list2.val:
                cur_node.next = ListNode(list1.val)
                list1 = list1.next
            else:
                cur_node.next = ListNode(list2.val)
                list2 = list2.next
            cur_node = cur_node.next

        while list1 is not None:
            cur_node.next = ListNode(list1.val)
            list1 = list1.next
            cur_node = cur_node.next
        while list2 is not None:
            cur_node.next = ListNode(list2.val)
            list2 = list2.next
            cur_node = cur_node.next


        return head
