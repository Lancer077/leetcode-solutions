/*
Didn't really mind this one all too much, the sorted array allowed for halving the array until you got to where you were looking for.
I didn't really feel like there was a clever solution for this one, moreso just slight optimizations.
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //do the halving trick to find the traget in O(log n)
        int indexA = 0;
        int indexB = nums.length;
        int halfway = (indexA + indexB) / 2;

        boolean found = false; //set a flag so we know when to stop
        int[] locations = new int[2]; //create the return array

        double logN = Math.log(nums.length);
        int loops = (int) Math.floor(logN) + 3;
        
        System.out.println(loops);

        for(int i = 0; i < loops; i++){ //add two 
            System.out.println(nums[halfway]);
            if(nums[halfway] > target){
                indexB = halfway;
            }
            else if(nums[halfway] < target){
                indexA = halfway;
            }
            else if(nums[halfway] == target){
                System.out.println(nums[halfway]);
                found = true; //break out of the loop
            }
            halfway = (indexA + indexB) / 2; 
        }

        System.out.println(found);

        //if we did not find the target in the array
        if(!found){
            System.out.println(found);
            locations[0] = -1;
            locations[1] = -1;
            return locations; //return the corresponding data
        }
        
        //if we did find the target, we now need to iterate forward and back to find the first and last locations
        //halfway is now a location of target
        //love reusing variables when it makes sense
        indexA = halfway;
        indexB = halfway;
        
        while(indexA > 0 && nums[indexA-1] == target){ //iterate backwards
            indexA--;
        }

        while(indexB < nums.length-1 && nums[indexB+1] == target){ //iterate forwards
            indexB++;
        }
        
        locations[0] = indexA; 
        locations[1] = indexB;

        return locations;

    }
}
