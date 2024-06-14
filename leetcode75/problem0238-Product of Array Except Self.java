/*
One of my favorite problems on this site. Such an elegant answer to something that seems very difficult. 
I could not have done it without loads of brainstorming and writing out my ideas on paper but it was really fun to work on this one.
https://leetcode.com/problems/product-of-array-except-self/description
https://leetcode.com/problems/product-of-array-except-self/submissions/1288535435
Tied with or beat 88% of submissions so I am somewhat proud of that but more just happy to be done with it.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] out = new int[nums.length];

        int product;

        //iterate forwards
        product = nums[0];
        for(int i = 1; i < nums.length; i++){
            out[i] = product;
            product = product * nums[i];
        }
      
        out[0] = 1; //if we don't do this the world will explode
      
        //iterate backwards
        product = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
            out[i] = out[i] * product;
            product = product * nums[i];
        }
        return out;
    }
}
