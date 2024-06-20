/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 https://leetcode.com/problems/reverse-linked-list/description
 https://leetcode.com/problems/reverse-linked-list/submissions/1294774623/
 Definitely gotten a little rusty on my linked list skills but hopefully I can start to get them back
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode curNode = head; 
        ListNode prev = null;
        ListNode next = null;

        while(curNode != null){
            next = curNode.next; //store the next node so we don't lose the pointer to it
            curNode.next = prev; //next is now prev
            prev = curNode; //update pointers
            curNode = next;
        }
        return prev; //the final prev is the new head

        
    }
}
