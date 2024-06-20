/*
https://leetcode.com/problems/maximum-average-subarray-i/
https://leetcode.com/problems/maximum-average-subarray-i/submissions/1294683024
Fun problem to start the less fun 9 hour shift at the rec center.
Not much to say about this one, tied with or beat 80% of submissions for time complexity
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        //sliding window approach

        //base case
        int sum = 0;
        for(int i = 0; i < k; i++){ //get the sum of the first location of the 'sliding window'
            sum += nums[i];
        }
        int max = sum; 

        //recursive case
        for(int i = k; i < nums.length; i++){ //iterate through the rest of the list
            sum -= nums[i-k]; //update the current sum
            sum += nums[i];
            max = Math.max(max, sum); //check if current sum is greater than max
        }
        
        double maxAverage = Double.valueOf(max) / Double.valueOf(k); //prevent integer division

        return maxAverage;
        
    }
}
