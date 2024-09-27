/*
https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/
https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/submissions/1404258995/
hashmap approach, probably could have gotten faster but I gotta go to work
fun little problem though
*/

class Solution {
    public int findMaxK(int[] nums) {
        
        HashMap<Integer, Integer> numList = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int curNum = nums[i];
            if(numList.containsKey(-curNum)){
                numList.put(curNum, 2);
            }
            else{
                numList.put(curNum, 1);
            }
        }

        int max = -1;

        for(int key : numList.keySet()){
            if(numList.get(key) == 2){
                int curNum = Math.abs(key);
                max = Math.max(curNum, max);
            }
        }

        return max;



    }
}
