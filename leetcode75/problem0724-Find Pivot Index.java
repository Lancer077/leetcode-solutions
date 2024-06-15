/*
https://leetcode.com/problems/find-pivot-index/description/
https://leetcode.com/problems/find-pivot-index/submissions/1289286648/

Nice and easy problem, started using one line simple if statements for code compression and readability
Submission tied with or beat 94% of others in time efficiency but that isn't exactly super impressive when tied with 88%
my approach: get a running left total and right total, increment through the array adding to the left total while subtracting from the right total
*/
class Solution {
    public int pivotIndex(int[] nums) {
        
        int left = 0;
        int right = 0;

        for(int i = 1; i < nums.length; i++){  //get the sum of the array (minus the first element) for the right total
            right = right + nums[i];
        }
        if(left == right){return 0;} //base case

        //recursive case
        for(int i = 1; i < nums.length; i++){
            left = left + nums[i-1];
            right = right - nums[i];
            if(left == right){return i;}
        }
        return -1;
    }
}
