/*
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/submissions/1310519767/
Daily Problem 7/5/2024

Enjoyable problem, definitely possible in one loop instead of two and also with faster data structures than a java list.
I used to really like linked lists but when doing leetcode it feels like I spend half the problem fighting their limitations.

10 points closer to getting that hat.

EDIT:

https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/submissions/1310562563
Afterwards I realized it would not be super hard to prevent doing two loops and also avoid using a slow java list.
I ended up with this, 4ms runtime, beat or tied with 100% of submissions, and it felt pretty darn good.
I rarely write code on my first try, often seeing the first attempt as something to learn from more so than a finished product, and this definitely was true here.

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        //edge case handling
        int[] arr = {-1, -1};
        if(head == null) { return arr; }
        if(head.next == null) { return arr; }
        if(head.next.next == null) { return arr; }

        ListNode prev = head;
        ListNode curNode = prev.next;
        ListNode next = curNode.next;

        int firstCriticalPoint = -1;
        int minDiff = Integer.MAX_VALUE;
        int prevCriticalPoint = -1;
        int index = 1;
        int pointCounter = 0;
        while(next != null){
            if((curNode.val > next.val && curNode.val > prev.val) || (curNode.val < next.val && curNode.val < prev.val)){ //check for critical point
                if(firstCriticalPoint == -1) { firstCriticalPoint = index; } //if first critical point not yet assigned, assign it
                if(prevCriticalPoint != -1){
                    minDiff = Math.min(minDiff, index - prevCriticalPoint);
                }
                prevCriticalPoint = index;
                pointCounter++;
            }
            index++;
            prev = curNode;
            curNode = next;
            next = next.next; // I hate this line with a burning passion
        }

        if(pointCounter < 2) { return arr; }
        arr[0] = minDiff;
        arr[1] = prevCriticalPoint - firstCriticalPoint;

        return arr;
        
    }
}
