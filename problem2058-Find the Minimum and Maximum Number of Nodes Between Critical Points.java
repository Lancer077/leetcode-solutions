/*
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/submissions/1310519767/
Daily Problem 7/5/2024

Enjoyable problem, definitely possible in one loop instead of two and also with faster data structures than a java list.
I used to really like linked lists but when doing leetcode it feels like I spend half the problem fighting their limitations.

10 points closer to getting that hat.

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

        List<Integer> criticalPoints = new ArrayList<Integer>();

        //handle edge cases
        int[] arr = {-1, -1};
        if(head == null){return arr;} //if we have 1 or 2 elements in the list
        if(head.next == null){return arr;} //return less than 2 critical points


        //the first and last nodes in the list cannot be critical points
        ListNode prev = head;
        ListNode curNode = prev.next; //so curNode is the second element in the list
        ListNode next = curNode.next;

        int index = 1; //starting at second node, technically doesn't matter because we are only looking for the difference
        while(next != null){
            if(curNode.val > next.val && curNode.val > prev.val){
                criticalPoints.add(index);
            }
            else if(curNode.val < next.val && curNode.val < prev.val){
                criticalPoints.add(index);
            }
            //increment everything to the next locations
            prev = curNode;
            curNode = next;
            next = next.next;
            index++;
        }
        
        //grab the size
        int size = criticalPoints.size();

        //if we have 0 or 1 critical points, then we return -1, -1
        if(size < 2){
            return arr;
        }
        
        //get the difference if it exists
        int minDiff = criticalPoints.get(1) - criticalPoints.get(0);
        if(size == 2){ //if we have just two critical points, then the max and min are the same
            arr[0] = minDiff;
            arr[1] = minDiff;
            return arr;
        }

        arr[1] = criticalPoints.get(size-1) - criticalPoints.get(0); //get the max and put it in the array
        for(int i = 1; i < size-1; i++){
            int curDiff = criticalPoints.get(i+1) - criticalPoints.get(i); //get the current difference
            minDiff = Math.min(curDiff, minDiff); //update minDiff
        }
        arr[0] = minDiff; //add minDiff to the return array

        return arr;

    }
}
