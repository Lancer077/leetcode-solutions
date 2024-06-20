/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/1294787977/
I have had easy problems that were far more difficult than this medium but I guess difficulty of coding problems is just too subjective.
I'd love to know if there is a solution that doesn't require the first pass through, but I don't think there is one unless you can somehow find the size of the list ahead of time.
Regardless, this definitely restored a bit of my confidence going forward with linked lists, as it took me less than 10 minutes to figure out and type up the solution.

 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {

        //plan: iterate through the list once, get the size
        //iterate through the list a second time and delete element at size/2
        int nodeCounter = 0;

        ListNode curNode = head;

        

        while(curNode != null){
            nodeCounter++;
            curNode = curNode.next;
        }

        curNode = head;

        if(nodeCounter == 1){
            return null;
        }

        for(int i = 0; i < (nodeCounter/2)-1; i++){
            curNode = curNode.next;
        }
        if(curNode.next != null && curNode.next.next != null){
            curNode.next = curNode.next.next;
        }
        else{
            curNode.next = null;
        }
        
        return head;
        

    }
}
