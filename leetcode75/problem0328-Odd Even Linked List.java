/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
https://leetcode.com/problems/odd-even-linked-list/description/
https://leetcode.com/problems/odd-even-linked-list/submissions/1294962833/
Not too difficult of a question but the O(1) space complexity constraint really tripped me up when I was considering how to approach the problem
After working through it on paper and literally writing down the lines of code required to complete each part of the problem, I figured out a
  way that tied for or beat 100% of submissions for time complexity. 

Definitely 

 
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        //approach: loop through once to get the tail of the list and the size
        ListNode tail = head; 
        int len = 1;
        while(tail != null && tail.next != null){
            tail = tail.next;
            len++;
        }

        //now we loop through the list, sending even numbers to the tail, and keeping odds
        ListNode curNode = head;
        ListNode nextNode;

        //special case: list size 2
        if(len == 2){ 
            return head;
        } 
        
        for(int i = 0; i < (len/2); i++){ 
            nextNode = curNode.next; //store the next even number
            curNode.next = curNode.next.next; //the current odd number now points to the next odd number
            nextNode.next = null; //the next even number will be at the end of the list so it does not need to point to anything
            tail.next = nextNode; //the next even goes to the end of the list
            tail = tail.next; //the new tail node is the next even
            curNode = curNode.next; //go to the next odd number in the list
        }

        return head;

    }
}
