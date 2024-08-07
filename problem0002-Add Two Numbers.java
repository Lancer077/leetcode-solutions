/*
https://leetcode.com/problems/add-two-numbers/description/
https://leetcode.com/problems/add-two-numbers/submissions/1347977015/

Back in action, a little rusty but still got the fast runtime that I was hoping for.
After taking a break for a couple of weeks (solar car) it's good to see that I still can do leetcode.
It took a bit longer than I wanted, probably about an hour, but I'm still vaguely proud of my work.

*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int a = l1.val;
        int b = l2.val;
        int c = a + b;
        int carry = 0;
        if(c > 9){
            carry = 1;
            c = c - 10;
        }

        //first node
        ListNode head = new ListNode(c); //our head to return later
        ListNode curNode = head; //travel between the nodes
        c = 0;
        

        while(l1.next != null || l2.next != null || carry == 1){
            if(l1.next != null){
                l1 = l1.next;
                a = l1.val;
            }
            else{
                a = 0;
            }
            if(l2.next != null){
                l2 = l2.next;
                b = l2.val;
            }
            else{
                b = 0;
            }

            //carry logic
            c = a + b + carry;
            carry = 0;
            if(c > 9){
                c = c - 10;
                carry = 1;
            }

            curNode.next = new ListNode(c);
            curNode = curNode.next;
            c = 0;

        }
        


        return head;



    }
}
