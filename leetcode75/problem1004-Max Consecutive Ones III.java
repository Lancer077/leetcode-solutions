/*
https://leetcode.com/problems/max-consecutive-ones-iii/description/
https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1304087814/

Had struggled with coding this one previously, the theory isn't the difficult part, unlike most leetcode problems.
Just had to map out a test case on paper and found a fairly optimal solution.
Ended up with making a slight optimization but quicky found a 2ms runtime, which is tied/beats 100% of others.
To be fair, it is not a super difficult problem to optimize.
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int curZeroes = 0;
        int curIndex = 0;

        while(curZeroes < k && curIndex < nums.length){
            if(nums[curIndex] == 0) {curZeroes++;}
            curIndex++;
        }

        int curSize = curIndex;
        int maxSize = curIndex;

        for(int i = curIndex; i < nums.length; i++){
            if(nums[i] == 1) { //make window larger
                curSize++;
                maxSize = Math.max(curSize, maxSize);
            } 
            else{ //if nums[i] == 0, we assume we are at capacity
                //we have a 'for' statement at home
                int j = i-curSize;
                while(nums[j] != 0){ //make window smaller
                    j++;
                    curSize--;
                }
            }
        }

        return maxSize;
    }
}
