/*
Was having a little trouble with this one yesterday, but I took a day off, wrote the first thing that came to mind today, and it worked like a charm
Originally was going to do the obvious O(n^2) solution, but then I realized working inward from the outside was O(n) and likely the intended solution
Fun problem, probably could have done it with less memory usage but I like readable code
https://leetcode.com/problems/container-with-most-water/description/

My first iteration took 5ms, but I had an idea on how to make it faster on data sets that were not bell curved shaped
Basically since we are moving inward, the difference will always be decreasing, so if the next height is not taller than the last, we don't even worry about computing it
Even if they are the same heights, it doesn't matter because we only iterate the shorter height between begin and end so if we have a 7 and a 9 and we iterate the first only for it to be another 7,
  it is still being multiplied by 1 less by the diff so we do not need to compute it
I like the problem even more now
*/
class Solution {
    public int maxArea(int[] height) {

        int max = 0;
        int begin = 0; //starting at the left 
        int end = height.length - 1; //starting at the right

        int diff = end - begin; //didn't need to make this a variable but it helps with general code reading and writing

        int min;

        int localMax = 0; //optimization code

        while(diff > 0){
            min = Math.min(height[begin], height[end]);
            max = Math.max(min * diff, max);

            if(height[begin] < height[end]){
                localMax = height[begin]; //optimization code
                begin++;
                while(localMax > height[begin]){ //optimization code
                    begin++; //optimization code
                }
                
            }
            else{
                localMax = height[end]; //optimization code
                end--;
                while(localMax > height[end]){ //optimization code
                    end--; //optimization code
                }
            }
            diff = end - begin;

        }

        return max;
    }
}
