/*
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/submissions/1304116168/

Fine problem, probably slightly harder than the very similar 'max consecutive ones' problem but sliding window approach remains the same.
95% speed efficiency lets gooooooo
Not much else to say about this one other than it's the last sliding window problem in the leetcode 75 category, and sliding windows will not be missed.
Okay maybe I'll miss them a little bit for their simplicity and elegance.

*/

class Solution {
    public int longestSubarray(int[] nums) {
        
        int curIndex = 0;
        int zeroes = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroes++;
                if(zeroes == 2) {break;} //be sure to break before adding the second zero
            }
            curIndex++;
        }
        if(curIndex == nums.length){return nums.length-1;}
        
        int curSize = curIndex; //technically could reuse curIndex instead of declaring
        int maxSize = curIndex; //two new variables but code clarity > space when that space is O(1)

        for(int i = curIndex; i < nums.length; i++){
            if(nums[i] != 0){
                curSize++;
                maxSize = Math.max(curSize, maxSize);
            }
            else{ //assume we are at capacity and next number is zero
                int j = i-curSize;
                while(nums[j] != 0){ //drop the ones that we will not have
                    j++;
                    curSize--;
                }
            }
        }

        return maxSize-1;

    }
}
