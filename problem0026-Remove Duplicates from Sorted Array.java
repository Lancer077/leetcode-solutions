/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/1304138895/

I have no clue what people have been able to do to reduce runtime because I'm doing things in O(n) with 1ms but I don't have the vaguest idea how 20% of people were able to reduce the runtime even further.
I just still have a lot to learn I guess.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int unique = 1;
        int prev = nums[0];

        //we can assume the first element of any array has not yet been found in that array
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != prev){
                prev = nums[i];
                nums[unique] = nums[i];
                unique++;
            }
        }

        return unique;
    }
}
