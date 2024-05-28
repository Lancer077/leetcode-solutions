//I know it is possible to use hashmaps for O(1) time complexity, and I will probably come back and update my solution with that at some point in the future
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j]== target){
                    int arr[] = {i, j};
                    return arr;
                }
            }
        }
        int arr[] = {-1, -1};
        return arr;
    }
}
