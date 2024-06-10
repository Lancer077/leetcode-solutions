/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
Wanted to do some easy problems just to get stuff in here more quickly and to become more well rounded
Kinda proud of the 3ms runtime but not very space efficient
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      
        boolean[] found = new boolean[nums.length]; //create a boolean array (Java initializes all of these as false)

        for(int i = 0; i < nums.length; i++){
            found[nums[i]-1] = true; //find the corresponding location in the boolean array and declare it true
        } 

        List<Integer> notFound = new ArrayList<Integer>(); //create a new int list for the integers not found in the array
        for(int i = 0; i < nums.length; i++){ //loop through
            if(!found[i]){
                notFound.add(i + 1);
            }
        }
        return notFound;
    }
}
