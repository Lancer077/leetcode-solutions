/*
https://leetcode.com/problems/missing-number/description/
Easy problem, I had 0ms runtime, tied with 60% of other solutions, was hoping for a solution faster than O(n^2) but unfortunately not the case 
*/

class Solution {
    public int missingNumber(int[] nums) {
        
        boolean[] found = new boolean[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            found[nums[i]] = true;
        }

        for(int i = 0; i < nums.length + 1; i++){ //O(n)
            if(!found[i]){ //O(n^2) 
                return i;
            }
        }
        return -1; //shouldn't ever return this
    }
}
